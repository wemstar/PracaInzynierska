package client.instrument.service;

import java.io.Serializable;
import java.util.List;

/**
 * Szczegóły instrumentów
 */
public class InstrumentListDetails implements Serializable {

    private String isin;
    private String name;
    private String market;
    private Double sellPrice;
    private Double buyPrice;
    private List<InstrumentHistory> historyList;

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public List<InstrumentHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<InstrumentHistory> historyList) {
        this.historyList = historyList;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
