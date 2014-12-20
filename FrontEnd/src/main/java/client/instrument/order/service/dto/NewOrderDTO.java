package client.instrument.order.service.dto;

import java.io.Serializable;

/**
 * Created by wemstar on 30.11.14.
 */
public class NewOrderDTO implements Serializable {
    private String instrument;
    private String market;
    private String side;
    private String type;
    private String accountNumber;
    private Double price;
    private Long amount;
    private Long id;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewOrderDTO{" +
                "instrument=" + instrument +
                ", market=" + market +
                ", side='" + side + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", accountNumber=" + accountNumber +
                '}';
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
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
