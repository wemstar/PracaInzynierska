package edu.agh.fis.interfaces.rest.instrument.market;

import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.instrument.market.MarketDTO;

import java.util.List;

/**
 * Transformuje obiekty transportowe in bazodanowe
 */
public interface MarketTransformer {
    MarketDTO entityToTransport(Markets marketEntity);

    List<MarketDTO> entityToTransportList(List<Markets> activeMarket);
}
