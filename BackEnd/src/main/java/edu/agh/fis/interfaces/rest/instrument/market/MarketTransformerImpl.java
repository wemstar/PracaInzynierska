package edu.agh.fis.interfaces.rest.instrument.market;

import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;
import edu.agh.fis.instrument.market.MarketDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionTransportBuilder.anInstrumentDefinitionTransport;
import static edu.agh.fis.builder.instrument.market.MarketDTOBuilder.aMarketDTO;

/**
 * Created by wemstar on 15.12.14.
 */

@Component
public class MarketTransformerImpl implements MarketTransformer {


    @Override
    public MarketDTO entityToTransport(Markets marketEntity) {
        MarketDTO marketDTO = aMarketDTO()
                .name(marketEntity.getName())
                .active(marketEntity.getActive())
                .build();
        List<InstrumentDefinitionDTO> list = new ArrayList<InstrumentDefinitionDTO>();
        if (marketEntity.getInstruments() != null)
            for (InstrumentMarket markins : marketEntity.getInstruments()) {
                list.add(anInstrumentDefinitionTransport()
                                .isin(markins.getInstrument().getIsin())
                                .build()
                );
            }
        marketDTO.setInstruments(list);
        return marketDTO;

    }

    @Override
    public List<MarketDTO> entityToTransportList(List<Markets> activeMarket) {
        List<MarketDTO> dtos = new ArrayList<MarketDTO>();
        for (Markets market : activeMarket) dtos.add(entityToTransport(market));
        return dtos;
    }
}
