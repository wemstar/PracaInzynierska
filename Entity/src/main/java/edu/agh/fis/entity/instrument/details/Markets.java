package edu.agh.fis.entity.instrument.details;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 15.12.14.
 */
@Entity
@Table(name = "MARKET")
public class Markets {

    @Id
    @Column(name = "MARKET_NAME", unique = true, nullable = false)
    private String name;


    @OneToMany(mappedBy = "market", fetch = FetchType.EAGER)
    private Set<InstrumentMarket> instruments;

    @Column(name = "MARKET_ENABLED")
    private Boolean enabled;
}
