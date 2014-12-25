package edu.agh.fis.core.trader;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Created by wemstar on 20.12.14.
 */
public interface BraAccountTrader {

    boolean checkAvalibility(NewOrder newOrder);

    void transferInstruments(NewOrder onMarket, NewOrder newOrder);
}
