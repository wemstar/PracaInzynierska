package edu.agh.fis.core.trader;

import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.Side;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 20.12.14.
 */
@Component
public class InstrumentCheckTraderImpl implements InstrumentCheckTrader {
    @Override
    public boolean checkOrder(NewOrder onMarket, NewOrder newOrder) {
        if (onMarket.getSide() != newOrder.getSide()) {
            if (newOrder.getSide() == Side.SELL && checkPrice(onMarket, newOrder))
                return true;
            else if (newOrder.getSide() == Side.BUY && checkPrice(newOrder, onMarket))
                return true;
        }


        return true;
    }

    private boolean checkPrice(NewOrder order1, NewOrder order2) {
        return order2.getPrice() <= order1.getPrice();
    }
}
