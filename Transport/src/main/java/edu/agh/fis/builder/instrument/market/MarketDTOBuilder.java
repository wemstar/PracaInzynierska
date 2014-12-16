package edu.agh.fis.builder.instrument.market;

import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;
import edu.agh.fis.instrument.market.MarketDTO;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
public class MarketDTOBuilder {
    private Boolean active;
    private String name;
    private String code;
    private List<InstrumentDefinitionDTO> instruments;

    private MarketDTOBuilder() {
    }

    public static MarketDTOBuilder aMarketDTO() {
        return new MarketDTOBuilder();
    }

    public MarketDTOBuilder active(Boolean active) {
        this.active = active;
        return this;
    }

    public MarketDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MarketDTOBuilder instruments(List<InstrumentDefinitionDTO> instruments) {
        this.instruments = instruments;
        return this;
    }

    public MarketDTOBuilder code(String code) {
        this.code = code;
        return this;
    }

    public MarketDTOBuilder but() {
        return aMarketDTO().active(active).name(name).instruments(instruments);
    }

    public MarketDTO build() {
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setActive(active);
        marketDTO.setName(name);
        marketDTO.setInstruments(instruments);
        marketDTO.setCode(code);
        return marketDTO;
    }
}
