package edu.agh.fis.core.trader;

import edu.agh.fis.core.instrument.order.services.NewOrderService;
import edu.agh.fis.core.trader.blocker.AccountBlocked;
import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by wemstar on 20.12.14.
 */
@Service
public class TraderExecutorImpl implements TraderExecutor {

    @Autowired
    private BraAccountTrader braAccountTrader;

    @Autowired
    private InstrumentCheckTrader instrumentCheckTrader;

    @Autowired
    private NewOrderService newOrderService;

    @Autowired
    private AccountValidator accountValidator;

    @Autowired
    private AccountBlocked blocker;

    @Override
    public void processOrder(NewOrder newOrder) {
        if (accountValidator.validateAccount(newOrder)) {
            if (newOrder.getSide() == Side.SELL)
                blocker.blockInstrument(newOrder.getBraAccount(), newOrder.getInstrument(), newOrder.getAmount());
            else
                blocker.blockCahs(newOrder.getBraAccount(), newOrder.getAmount() * newOrder.getPrice());
            Set<NewOrder> ordersOnMarket = newOrder.getMarket().getOrders();
            for (NewOrder order : ordersOnMarket) {
                if (instrumentCheckTrader.checkOrder(order, newOrder)) {
                    braAccountTrader.transferInstruments(order, newOrder);
                    newOrderService.procesNewOrders(order, newOrder);
                }
            }
        }

    }


}
