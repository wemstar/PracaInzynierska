package edu.agh.fis.builder.entity.instrument.details;

import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;

import java.util.Set;

/**
 * Builder dla definicji instrumentów
 */
public class InstrumentDefinitionBuilder {
    private Set<InstrumentInfo> instrumentInfos;
    private Set<InstrumentMarket> markets;
    private String isin;
    private String name;

    private InstrumentDefinitionBuilder() {
    }

    public static InstrumentDefinitionBuilder anInstrumentDefinition() {
        return new InstrumentDefinitionBuilder();
    }

    public InstrumentDefinitionBuilder instrumentInfos(Set<InstrumentInfo> instrumentInfos) {
        this.instrumentInfos = instrumentInfos;
        return this;
    }

    public InstrumentDefinitionBuilder markets(Set<InstrumentMarket> markets) {
        this.markets = markets;
        return this;
    }

    public InstrumentDefinitionBuilder isin(String isin) {
        this.isin = isin;
        return this;
    }

    public InstrumentDefinitionBuilder name(String name) {
        this.name = name;
        return this;
    }

    public InstrumentDefinitionBuilder but() {
        return anInstrumentDefinition().instrumentInfos(instrumentInfos).markets(markets).isin(isin).name(name);
    }

    public InstrumentDefinition build() {
        InstrumentDefinition instrumentDefinition = new InstrumentDefinition();
        instrumentDefinition.setInstrumentInfos(instrumentInfos);
        instrumentDefinition.setMarkets(markets);
        instrumentDefinition.setIsin(isin);
        instrumentDefinition.setName(name);
        return instrumentDefinition;
    }
}
