package edu.agh.fis.core.trader;

import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.Side;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 04.01.15.
 */
@Component
public class AccountValidatorImpl implements AccountValidator {

    @Override
    public boolean validateAccount(NewOrder newOrder) {
        if (newOrder.getSide() == Side.BUY && newOrder.getBraAccount().getAvalibleCash() > newOrder.getAmount() * newOrder.getPrice())
            return true;
        else if (newOrder.getSide() == Side.SELL) {
            for (InstrumentInfo info : newOrder.getBraAccount().getInstruments()) {
                if (info.getInstrumentDefinition().getIsin().equals(newOrder.getInstrument().getIsin()) && info.getAmmount() > newOrder.getAmount())
                    return true;
            }
        }
        return false;
    }
}
