package edu.agh.fis.core.instrument.order.services;


import edu.agh.fis.entity.instrument.order.NewOrder;

import java.util.List;

/**
 * Created by wemstar on 17.12.14.
 */
public interface NewOrderService {
    NewOrder createNewOrder(NewOrder newOrderAgregate);

    List<NewOrder> getOrdeListForClient(Long clientNo);

    void procesNewOrders(NewOrder onMarket, NewOrder newOrder);
}
