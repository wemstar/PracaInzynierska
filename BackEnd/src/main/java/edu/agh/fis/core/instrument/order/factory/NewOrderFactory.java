package edu.agh.fis.core.instrument.order.factory;


import edu.agh.fis.core.instrument.order.agregate.NewOrderAgregate;

/**
 * Created by wemstar on 17.12.14.
 */
public interface NewOrderFactory {
    NewOrderFactory createNew();

    NewOrderAgregate build();

    NewOrderFactory instrument(String instrument);

    NewOrderFactory market(String market);

    NewOrderFactory side(String side);

    NewOrderFactory price(Double price);

    NewOrderFactory type(String type);

    NewOrderFactory ammount(Long amount);
}
