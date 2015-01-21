package edu.agh.fis.builder.entity.instrument.order;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.OrderType;
import edu.agh.fis.enums.order.Side;

/**
 * Builder dla nowego zlecenia
 */
public class NewOrderBuilder {
    private Long amount;
    private Long id;
    private InstrumentDefinition instrument;
    private Markets market;
    private Side side;
    private OrderType type;
    private Double price;
    private BraAccount braAccount;
    private String fix;

    private NewOrderBuilder() {
    }

    public static NewOrderBuilder aNewOrder() {
        return new NewOrderBuilder();
    }

    public NewOrderBuilder amount(Long amount) {
        this.amount = amount;
        return this;
    }

    public NewOrderBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public NewOrderBuilder instrument(InstrumentDefinition instrument) {
        this.instrument = instrument;
        return this;
    }

    public NewOrderBuilder market(Markets market) {
        this.market = market;
        return this;
    }

    public NewOrderBuilder side(Side side) {
        this.side = side;
        return this;
    }

    public NewOrderBuilder type(OrderType type) {
        this.type = type;
        return this;
    }

    public NewOrderBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public NewOrderBuilder braAccount(BraAccount braAccount) {
        this.braAccount = braAccount;
        return this;
    }

    public NewOrderBuilder fix(String fix) {
        this.fix = fix;
        return this;
    }


    public NewOrderBuilder but() {
        return aNewOrder().amount(amount).id(id).instrument(instrument).market(market).side(side).type(type).price(price).braAccount(braAccount);
    }

    public NewOrder build() {
        NewOrder newOrder = new NewOrder();
        newOrder.setAmount(amount);
        newOrder.setId(id);
        newOrder.setInstrument(instrument);
        newOrder.setMarket(market);
        newOrder.setSide(side);
        newOrder.setType(type);
        newOrder.setPrice(price);
        newOrder.setBraAccount(braAccount);
        newOrder.setFix(fix);
        return newOrder;
    }
}
