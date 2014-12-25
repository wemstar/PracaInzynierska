package edu.agh.fis.entity.instrument.details;


import edu.agh.fis.entity.instrument.order.NewOrder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 15.12.14.
 */
@Entity
@Table(name = "MARKET")
public class Markets {

    @Id
    @Column(name = "MARKET_CODE", unique = true, nullable = false)
    private String code;
    @OneToMany(mappedBy = "market", fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @Fetch(FetchMode.JOIN)
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
}
