package edu.agh.fis.builder.entity.instrument.details;

import edu.agh.fis.entity.instrument.details.InstrumentHistory;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;

import java.util.Date;

/**
 * Builder dla histori instrumentów
 */
public class InstrumentHistoryBuilder {
    private Double closePrice;
    private Long id;
    private InstrumentMarket instrumentMarket;
    private Date date;
    private Double openPrice;
    private Double minPrice;
    private Double maxPrice;

    private InstrumentHistoryBuilder() {
    }

    public static InstrumentHistoryBuilder anInstrumentHistory() {
        return new InstrumentHistoryBuilder();
    }

    public InstrumentHistoryBuilder closePrice(Double closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public InstrumentHistoryBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public InstrumentHistoryBuilder instrumentMarket(InstrumentMarket instrumentMarket) {
        this.instrumentMarket = instrumentMarket;
        return this;
    }

    public InstrumentHistoryBuilder date(Date date) {
        this.date = date;
        return this;
    }

    public InstrumentHistoryBuilder openPrice(Double openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public InstrumentHistoryBuilder minPrice(Double minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public InstrumentHistoryBuilder maxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public InstrumentHistoryBuilder but() {
        return anInstrumentHistory().closePrice(closePrice).id(id).instrumentMarket(instrumentMarket).date(date).openPrice(openPrice).minPrice(minPrice).maxPrice(maxPrice);
    }

    public InstrumentHistory build() {
        InstrumentHistory instrumentHistory = new InstrumentHistory();
        instrumentHistory.setClosePrice(closePrice);
        instrumentHistory.setId(id);
        instrumentHistory.setInstrumentMarket(instrumentMarket);
        instrumentHistory.setDate(date);
        instrumentHistory.setOpenPrice(openPrice);
        instrumentHistory.setMinPrice(minPrice);
        instrumentHistory.setMaxPrice(maxPrice);
        return instrumentHistory;
    }
}
