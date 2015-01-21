package edu.agh.fis.core.trader;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Paruje zlecenia
 */
public interface InstrumentCheckTrader {
    /**
     * Sprawdza czy zlecenie są sparowane
     *
     * @param onMarket zleceni 1
     * @param newOrder zlecenie 2
     * @return TRUE jeśli zlecenia mogą byc sparowane
     */
    boolean checkOrder(NewOrder onMarket, NewOrder newOrder);
}
