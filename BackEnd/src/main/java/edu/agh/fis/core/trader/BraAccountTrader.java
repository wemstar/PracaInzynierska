package edu.agh.fis.core.trader;

import edu.agh.fis.entity.instrument.order.NewOrder;

/**
 * obsługuje operacje na rachunka przy przetwarzaniu zleceń
 */
public interface BraAccountTrader {

    /**
     * sprawdza dostępnośc instrumentu na rachunku
     *
     * @param newOrder
     * @return
     */
    boolean checkAvalibility(NewOrder newOrder);

    /**
     * przeności instrumenty miedzy rachunkami
     * @param onMarket
     * @param newOrder
     */
    void transferInstruments(NewOrder onMarket, NewOrder newOrder);
}
