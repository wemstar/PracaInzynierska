package edu.agh.fis.core.trader;

import edu.agh.fis.core.bra.acc.presistance.BraAccountDao;
import edu.agh.fis.core.trader.blocker.AccountBlocked;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static edu.agh.fis.builder.entity.bra.acc.InstrumentInfoBuilder.anInstrumentInfo;

/**
 * Created by wemstar on 20.12.14.
 */
@Component
public class BraAccountTraderImpl implements BraAccountTrader {

    @Autowired
    private BraAccountDao braAccountDao;

    @Autowired
    private AccountBlocked blocked;


    @Override
    public boolean checkAvalibility(NewOrder newOrder) {
        boolean result;
        if (newOrder.getSide() == Side.BUY)
            result = checkAvalibleCash(newOrder);
        else
            result = checkAvailableInstruments(newOrder);

        return result;
    }

    private boolean checkAvailableInstruments(NewOrder newOrder) {

        for (InstrumentInfo info : newOrder.getBraAccount().getInstruments()) {
            if (info.getInstrumentDefinition().getIsin().equals(newOrder.getInstrument().getIsin())
                    && info.getAmmount() >= newOrder.getAmount()) return true;
        }
        return false;
    }

    private boolean checkAvalibleCash(NewOrder newOrder) {

        Double fullPrice = newOrder.getAmount() * newOrder.getPrice();
        if (fullPrice <= newOrder.getBraAccount().getAvalibleCash())
            return true;
        return false;
    }

    @Override
    public void transferInstruments(NewOrder onMarket, NewOrder newOrder) {

        Long amount = onMarket.getAmount() - newOrder.getAmount();
        BraAccount seller = onMarket.getSide() == Side.SELL ? onMarket.getBraAccount() : newOrder.getBraAccount();
        BraAccount buyer = onMarket.getSide() == Side.BUY ? onMarket.getBraAccount() : newOrder.getBraAccount();
        if (amount < 0) {
            onMarket.setAmount(0L);
            newOrder.setAmount(-amount);
        } else if (amount > 0) {
            onMarket.setAmount(amount);
            newOrder.setAmount(0L);
        } else if (amount == 0) {
            amount = onMarket.getAmount();
            onMarket.setAmount(0L);
            newOrder.setAmount(0L);
        }
        acountTransfer(seller, buyer, onMarket.getInstrument(), amount, onMarket.getPrice() * onMarket.getAmount());
        braAccountDao.update(seller);
        braAccountDao.update(buyer);

    }

    private void acountTransfer(BraAccount seller, BraAccount buyer, InstrumentDefinition instrument, Long amount, Double price) {

        //przelewa pieniadze na rachunek właściciela
        for (InstrumentInfo info : seller.getInstruments())
            if (info.getInstrumentDefinition().getIsin().equals(instrument.getIsin())) {
                info.setBlocked(info.getBlocked() - amount);

                if (info.getAmmount() == 0 && info.getBlocked() == 0) {
                    seller.getInstruments().remove(info);
                }
            }

        //przelewa instrument na rachunek odbiorcy
        if (buyer.getInstruments().contains(anInstrumentInfo().instrumentDefinition(instrument).build())) {
            for (InstrumentInfo info : buyer.getInstruments())
                if (info.getInstrumentDefinition().getIsin().equals(instrument.getIsin())) {
                    info.setAmmount(info.getAmmount() + amount);


                }
        } else {

            buyer.getInstruments().add(anInstrumentInfo()
                    .ammount(amount)
                    .blocked(0)
                    .braAccount(buyer)
                    .instrumentDefinition(instrument)
                    .build());


        }
        seller.setAvalibleCash(seller.getAvalibleCash() + price);
        buyer.setBlockCash(buyer.getBlockCash() - price);


    }
}
