package edu.agh.fis.interfaces.rest.instrument.market;

import edu.agh.fis.instrument.market.MarketDTO;

import java.util.List;

/**
 * Przetwarza zapytanie REST dla rynków
 */
public interface MarketRest {

    public List<MarketDTO> getActiveMarket();
}
