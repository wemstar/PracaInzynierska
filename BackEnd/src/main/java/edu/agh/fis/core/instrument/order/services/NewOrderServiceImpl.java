package edu.agh.fis.core.instrument.order.services;

import edu.agh.fis.core.instrument.order.agregate.NewOrderAgregate;
import org.springframework.stereotype.Service;

/**
 * Created by wemstar on 17.12.14.
 */
@Service
public class NewOrderServiceImpl implements NewOrderService {
    @Override
    public NewOrderAgregate procesOrder(NewOrderAgregate newOrderAgregate) {
        return null;
    }
}
