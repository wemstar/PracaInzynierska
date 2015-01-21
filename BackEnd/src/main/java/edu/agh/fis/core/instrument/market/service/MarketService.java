package edu.agh.fis.core.instrument.market.service;

import edu.agh.fis.entity.instrument.details.Markets;

import java.util.List;

/**
 * Logika biznesowa dla rynków
 */
public interface MarketService {

    /**
     * @return lista aktywnych rynków
     */
    List<Markets> getActiveMarket();
}
