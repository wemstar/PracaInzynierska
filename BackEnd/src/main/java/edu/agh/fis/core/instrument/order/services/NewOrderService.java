package edu.agh.fis.core.instrument.order.services;

import edu.agh.fis.core.instrument.order.agregate.NewOrderAgregate;

/**
 * Created by wemstar on 17.12.14.
 */
public interface NewOrderService {
    NewOrderAgregate procesOrder(NewOrderAgregate newOrderAgregate);
}
