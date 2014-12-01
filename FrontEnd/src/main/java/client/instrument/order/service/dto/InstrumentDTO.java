package client.instrument.order.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wemstar on 30.11.14.
 */
public class InstrumentDTO implements Serializable {

    private String isin;
    private String name;
    private int count;
    private List<MarketDTO> market;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<MarketDTO> getMarket() {
        return market;
    }

    public void setMarket(List<MarketDTO> market) {
        this.market = market;
    }
}
