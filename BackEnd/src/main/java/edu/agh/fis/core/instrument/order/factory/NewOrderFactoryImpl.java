package edu.agh.fis.core.instrument.order.factory;

import edu.agh.fis.core.instrument.order.agregate.NewOrderAgregate;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 17.12.14.
 */
@Component
public class NewOrderFactoryImpl implements NewOrderFactory {
    @Override
    public NewOrderFactory createNew() {
        return null;
    }

    @Override
    public NewOrderAgregate build() {
        return null;
    }

    @Override
    public NewOrderFactory instrument(String instrument) {
        return null;
    }

    @Override
    public NewOrderFactory market(String market) {
        return null;
    }

    @Override
    public NewOrderFactory side(String side) {
        return null;
    }

    @Override
    public NewOrderFactory price(Double price) {
        return null;
    }

    @Override
    public NewOrderFactory type(String type) {
        return null;
    }

    @Override
    public NewOrderFactory ammount(Long amount) {
        return null;
    }
}
