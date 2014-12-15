package edu.agh.fis.core.instrument.market.service;

import edu.agh.fis.entity.instrument.details.Markets;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
public interface MarketService {
    List<Markets> getActiveMarket();
}
