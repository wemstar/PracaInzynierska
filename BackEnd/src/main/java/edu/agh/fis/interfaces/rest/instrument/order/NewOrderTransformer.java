package edu.agh.fis.interfaces.rest.instrument.order;

import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.instrument.order.NewOrderDTO;

/**
 * Created by wemstar on 17.12.14.
 */
public interface NewOrderTransformer {
    NewOrderDTO entityToTransport(NewOrder rootEntity);
}
