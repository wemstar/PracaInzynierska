package edu.agh.fis.entity.instrument.details;

import javax.persistence.*;

/**
 * Created by wemstar on 15.12.14.
 */
@Entity
@Table(name = "INSTRUMENT_MARKET")
public class InstrumentMarket {

    @Id
    @Column(name = "INSTRUMENT_MARKET_ID", nullable = false, unique = true)
    private long id;

    @JoinColumn(name = "INSTRUMENT_MARKET_MARKET", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Markets market;
    @JoinColumn(name = "INSTRUMENT_MARKET_INSTRUMENT", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private InstrumentDefinition instrument;
    @Column(name = "INSTRUMENT_MARKET_SELL_PRICE", nullable = false)
    private Double sellPrice;
    @Column(name = "INSTRUMENT_MARKET_BUY_PRICE")
    private Double buyPrice;

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InstrumentDefinition getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentDefinition instrument) {
        this.instrument = instrument;
    }

    public Markets getMarket() {
        return market;
    }

    public void setMarket(Markets market) {
        this.market = market;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
