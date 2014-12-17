package edu.agh.fis.core.instrument.order.agregate;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Created by wemstar on 17.12.14.
 */
public interface NewOrderAgregate {
    NewOrder getRootEntity();
}
