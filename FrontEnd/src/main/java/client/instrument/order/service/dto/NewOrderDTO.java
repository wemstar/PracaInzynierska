package client.instrument.order.service.dto;

import java.io.Serializable;

/**
 * Created by wemstar on 30.11.14.
 */
public class NewOrderDTO implements Serializable {
    private InstrumentDTO instrument;
    private MarketDTO market;
    private String side;
    private String type;
    private Double price;
    private Long amount;

    @Override
    public String toString() {
        return "NewOrderDTO{" +
                "instrument=" + instrument +
                ", market=" + market +
                ", side='" + side + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public InstrumentDTO getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentDTO instrument) {
        this.instrument = instrument;
    }

    public MarketDTO getMarket() {
        return market;
    }

    public void setMarket(MarketDTO market) {
        this.market = market;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
