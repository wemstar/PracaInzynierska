package edu.agh.fis.core.fix;

import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.OrderType;
import org.springframework.stereotype.Component;
import quickfix.field.*;
import quickfix.fix41.NewOrderSingle;

/**
 * Created by wemstar on 26.12.14.
 */
@Component
public class SendMessageImpl implements SendMessage {


    @Override
    public void sendMessage(NewOrder order) {

        NewOrderSingle single = new NewOrderSingle(
                new ClOrdID(order.getBraAccount().getClientFile().getClientNo().toString()),
                new HandlInst(HandlInst.MANUAL_ORDER),
                new Symbol(order.getInstrument().getIsin()),
                new Side(order.getSide() == edu.agh.fis.enums.order.Side.BUY ? Side.BUY : Side.SELL),
                new OrdType(getOrderType(order.getType()))
        );
        single.set(new Account("" + order.getBraAccount().getId()));
        single.set(new Currency("PLN"));
        single.set(new OrderQty(order.getAmount()));
        single.set(new Price(order.getPrice()));
        order.setFix(single.toString().replaceAll("\\01", "|"));

    }

    public char getOrderType(OrderType type) {
        switch (type) {
            case Limit:
                return OrdType.LIMIT;
            case PCR:
                return OrdType.MARKET;
            case PKC:
                return OrdType.MARKET_WITH_LEFTOVER_AS_LIMIT;
            case StopLimit:
                return OrdType.STOP_LIMIT;
            case StopLoss:
                return OrdType.STOP;
        }
        return 'a';
    }

}
