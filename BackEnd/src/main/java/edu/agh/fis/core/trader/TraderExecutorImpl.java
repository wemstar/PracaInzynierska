package edu.agh.fis.core.trader;

import edu.agh.fis.core.instrument.order.services.NewOrderService;
import edu.agh.fis.entity.instrument.order.NewOrder;
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

    @Override
    public void processOrder(NewOrder newOrder) {
        Set<NewOrder> ordersOnMarket = newOrder.getMarket().getOrders();
        for (NewOrder order : ordersOnMarket) {
            if (instrumentCheckTrader.checkOrder(order, newOrder)) {
                braAccountTrader.transferInstruments(order, newOrder);
                newOrderService.procesNewOrders(order, newOrder);
            }
        }

    }


}
