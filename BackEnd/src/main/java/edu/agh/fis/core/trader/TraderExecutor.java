package edu.agh.fis.core.trader;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * Klasa przetwarzające zlecenia
 */
public interface TraderExecutor {
    /**
     * Przetwórz zlecenie
     *
     * @param newOrder
     */
    void processOrder(NewOrder newOrder);
}
