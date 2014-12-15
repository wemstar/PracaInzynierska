package edu.agh.fis.builder.entity.instrument.details;

import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;

import java.util.Set;

/**
 * Created by wemstar on 15.12.14.
 */
public class MarketsBuilder {
    private Boolean active;
    private String name;
    private Set<InstrumentMarket> instruments;

    private MarketsBuilder() {
    }

    public static MarketsBuilder aMarkets() {
        return new MarketsBuilder();
    }

    public MarketsBuilder active(Boolean active) {
        this.active = active;
        return this;
    }

    public MarketsBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MarketsBuilder instruments(Set<InstrumentMarket> instruments) {
        this.instruments = instruments;
        return this;
    }

    public MarketsBuilder but() {
        return aMarkets().active(active).name(name).instruments(instruments);
    }

    public Markets build() {
        Markets markets = new Markets();
        markets.setActive(active);
        markets.setName(name);
        markets.setInstruments(instruments);
        return markets;
    }
}
