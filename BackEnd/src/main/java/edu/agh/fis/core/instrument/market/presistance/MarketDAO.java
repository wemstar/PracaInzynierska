package edu.agh.fis.core.instrument.market.presistance;

import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.utils.presistance.AbstractDAO;

import java.util.List;

/**
 * Wyciąga z bazy dane dotyczące Rynków
 */
public interface MarketDAO extends AbstractDAO<Markets> {

    /**
     * @return Lista aktywnych wynków
     */
    List<Markets> getActiveMarkets();

    /**
     *
     * @param market kod rynku
     * @return rynek
     */
    Markets find(String market);
}
