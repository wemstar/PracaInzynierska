package edu.agh.fis.builder.instrument.order;

import edu.agh.fis.instrument.order.NewOrderDTO;

/**
 * Builder dla DTO nowego zlecenia
 */
public class NewOrderDTOBuilder {
    private Long amount;
    private String instrument;
    private String market;
    private String side;
    private String type;
    private Double price;
    private Long id;
    private String accountNumber;
    private String fix;

    private NewOrderDTOBuilder() {
    }

    public static NewOrderDTOBuilder aNewOrderDTO() {
        return new NewOrderDTOBuilder();
    }

    public NewOrderDTOBuilder amount(Long amount) {
        this.amount = amount;
        return this;
    }

    public NewOrderDTOBuilder instrument(String instrument) {
        this.instrument = instrument;
        return this;
    }

    public NewOrderDTOBuilder market(String market) {
        this.market = market;
        return this;
    }

    public NewOrderDTOBuilder side(String side) {
        this.side = side;
        return this;
    }

    public NewOrderDTOBuilder type(String type) {
        this.type = type;
        return this;
    }

    public NewOrderDTOBuilder fix(String fix) {
        this.fix = fix;
        return this;
    }

    public NewOrderDTOBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public NewOrderDTOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public NewOrderDTOBuilder accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public NewOrderDTOBuilder but() {
        return aNewOrderDTO().amount(amount).instrument(instrument).market(market).side(side).type(type).price(price).id(id);
    }

    public NewOrderDTO build() {
        NewOrderDTO newOrderDTO = new NewOrderDTO();
        newOrderDTO.setAmount(amount);
        newOrderDTO.setInstrument(instrument);
        newOrderDTO.setMarket(market);
        newOrderDTO.setSide(side);
        newOrderDTO.setType(type);
        newOrderDTO.setPrice(price);
        newOrderDTO.setId(id);
        newOrderDTO.setAccountNumber(accountNumber);
        newOrderDTO.setFix(fix);
        return newOrderDTO;
    }
}
