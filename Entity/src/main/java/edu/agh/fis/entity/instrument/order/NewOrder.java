package edu.agh.fis.entity.instrument.order;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.enums.order.OrderType;
import edu.agh.fis.enums.order.Side;

import javax.persistence.*;

/**
 * Zlecenie
 */
@Entity
@Table(name = "NEW_ORDER")
public class NewOrder {

    @Id
    @Column(name = "NEW_ORDER_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "NEW_ORDER_INSTRUMENT", nullable = false)
    private InstrumentDefinition instrument;

    @ManyToOne
    @JoinColumn(name = "NEW_ORDER_MARKET", nullable = false)
    private Markets market;

    @Column(name = "NEW_ORDER_SIDE", nullable = false)
    private Side side;

    @Column(name = "NEW_ORDER_TYPE", nullable = false)
    private OrderType type;

    @Column(name = "NEW_ORDER_PRICE", nullable = false)
    private Double price;

    @Column(name = "NEW_ORDER_AMOUNT", nullable = false)
    private Long amount;

    @JoinColumn(name = "NEW_ORDER_BRA_ACCOUNT", nullable = false)
    @ManyToOne
    private BraAccount braAccount;

    @Column(name = "NEW_ORDER_FIX", nullable = false)
    private String fix;

    public BraAccount getBraAccount() {
        return braAccount;
    }

    public void setBraAccount(BraAccount braAccount) {
        this.braAccount = braAccount;
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
                '}';
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }
}
