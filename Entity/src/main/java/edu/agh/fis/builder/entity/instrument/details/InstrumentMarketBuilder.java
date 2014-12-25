package edu.agh.fis.builder.entity.instrument.details;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.entity.instrument.details.InstrumentHistory;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;

import java.util.List;

/**
 * Created by wemstar on 16.12.14.
 */
public class InstrumentMarketBuilder {
    private Double buyPrice;
    private long id;
    private Markets market;
    private InstrumentDefinition instrument;
    private Double sellPrice;
    private List<InstrumentHistory> history;

    private InstrumentMarketBuilder() {
    }

    public static InstrumentMarketBuilder anInstrumentMarket() {
        return new InstrumentMarketBuilder();
    }

    public InstrumentMarketBuilder buyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
        return this;
    }

    public InstrumentMarketBuilder id(long id) {
        this.id = id;
        return this;
    }

    public InstrumentMarketBuilder market(Markets market) {
        this.market = market;
        return this;
    }

    public InstrumentMarketBuilder instrument(InstrumentDefinition instrument) {
        this.instrument = instrument;
        return this;
    }

    public InstrumentMarketBuilder sellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
        return this;
    }

    public InstrumentMarketBuilder history(List<InstrumentHistory> history) {
        this.history = history;
        return this;
    }

    public InstrumentMarketBuilder but() {
        return anInstrumentMarket().buyPrice(buyPrice).id(id).market(market).instrument(instrument).sellPrice(sellPrice);
    }

    public InstrumentMarket build() {
        InstrumentMarket instrumentMarket = new InstrumentMarket();
        instrumentMarket.setBuyPrice(buyPrice);
        instrumentMarket.setId(id);
        instrumentMarket.setMarket(market);
        instrumentMarket.setInstrument(instrument);
        instrumentMarket.setSellPrice(sellPrice);
        instrumentMarket.setHistory(history);
        return instrumentMarket;
    }
}
