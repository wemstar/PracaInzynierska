package edu.agh.fis.entity.instrument.details;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
@Entity
@Table(name = "INSTRUMENT_MARKET")
public class InstrumentMarket {

    @Id
    @Column(name = "INSTRUMENT_MARKET_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JoinColumn(name = "INSTRUMENT_MARKET_MARKET", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Markets market;
    @JoinColumn(name = "INSTRUMENT_MARKET_INSTRUMENT", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private InstrumentDefinition instrument;
    @Column(name = "INSTRUMENT_MARKET_SELL_PRICE", nullable = false)
    private Double sellPrice;
    @Column(name = "INSTRUMENT_MARKET_BUY_PRICE", nullable = false)
    private Double buyPrice;

    @Column(name = "INSTRUMENT_MARKET_MIN_PRICE")
    private Double minPrice;
    @Column(name = "INSTRUMENT_MARKET_MAX_PRICE")
    private Double maxPrice;

    @OneToMany(mappedBy = "instrumentMarket", fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @OrderBy("date")
    private List<InstrumentHistory> history;

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

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public List<InstrumentHistory> getHistory() {
        return history;
    }

    public void setHistory(List<InstrumentHistory> history) {
        this.history = history;
    }
}
