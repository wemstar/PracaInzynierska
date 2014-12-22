package edu.agh.fis.instrument.list;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wemstar on 21.12.14.
 */
public class InstrumentHistoryDTO implements Serializable {

    private Date date;
    private Double openPrice;
    private Double closePrice;
    private Double minPrice;
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
}
