package edu.agh.fis.core.instrument.market.presistance;

import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.utils.presistance.AbstractDAO;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
public interface MarketDAO extends AbstractDAO<Markets> {
    List<Markets> getActiveMarkets();

    Markets find(String market);
}
