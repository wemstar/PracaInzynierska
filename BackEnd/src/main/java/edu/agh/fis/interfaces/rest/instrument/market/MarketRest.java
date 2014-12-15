package edu.agh.fis.interfaces.rest.instrument.market;

import edu.agh.fis.instrument.market.MarketDTO;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
public interface MarketRest {

    public List<MarketDTO> getActiveMarket();
}
