package edu.agh.fis.interfaces.rest.instrument.order;

import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.instrument.order.NewOrderDTO;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 17.12.14.
 */
@Component
public class NewOrderTransformerImpl implements NewOrderTransformer {
    @Override
    public NewOrderDTO entityToTransport(NewOrder rootEntity) {
        return null;
    }
}
