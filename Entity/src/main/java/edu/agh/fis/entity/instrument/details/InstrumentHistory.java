package edu.agh.fis.entity.instrument.details;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wemstar on 21.12.14.
 */
@Entity
@Table(name = "INSTRUMENT_HISTORY")
public class InstrumentHistory {

    @Id
    @Column(name = "INSTRUMENT_HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "INSTRUMENT_HISTORY_INSTRUMENT_MARKET", nullable = false)
    @Fetch(FetchMode.JOIN)
    private InstrumentMarket instrumentMarket;

    @Column(name = "INSTRUMENT_HISTORY_DATE", nullable = false, unique = true)
    private Date date;
    @Column(name = "INSTRUMENT_HISTORY_OPEN_PRICE")
    private Double openPrice;
    @Column(name = "INSTRUMENT_HISTORY_CLOSE_PRICE")
    private Double closePrice;
    @Column(name = "INSTRUMENT_HISTORY_MIN_PRICE")
    private Double minPrice;
    @Column(name = "INSTRUMENT_HISTORY_MAX_PRICE")
    private Double maxPrice;

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstrumentMarket getInstrumentMarket() {
        return instrumentMarket;
    }

    public void setInstrumentMarket(InstrumentMarket instrumentMarket) {
        this.instrumentMarket = instrumentMarket;
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

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    @Override
    public String toString() {
        return "InstrumentHistory{" +
                "closePrice=" + closePrice +
                ", date=" + date +
                ", id=" + id +
                ", instrumentMarket=" + instrumentMarket.getId() +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", openPrice=" + openPrice +
                '}';
    }
}
