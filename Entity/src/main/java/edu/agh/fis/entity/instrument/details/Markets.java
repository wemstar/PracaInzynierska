package edu.agh.fis.entity.instrument.details;


import edu.agh.fis.entity.instrument.order.NewOrder;

import javax.persistence.*;
import java.util.Set;

/**
 * Rynek
 */
@Entity
@Table(name = "MARKET")
public class Markets {

    @Id
    @Column(name = "MARKET_CODE", unique = true, nullable = false)
    private String code;
    @OneToMany(mappedBy = "market")
    //@Fetch(FetchMode.JOIN)
    private Set<InstrumentMarket> instruments;
    @Column(name = "MARKET_ACTIVE")
    private Boolean active;
    @Column(name = "MARKET_NAME")
    private String name;

    @OneToMany(mappedBy = "market", fetch = FetchType.EAGER)
    private Set<NewOrder> orders;

    public Set<NewOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<NewOrder> orders) {
        this.orders = orders;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<InstrumentMarket> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<InstrumentMarket> instruments) {
        this.instruments = instruments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Markets{" +
                "name='" + name + '\'' +
                ", instruments=" + instruments +
                ", code='" + code + '\'' +
                ", active=" + active +
                '}';
    }
}
