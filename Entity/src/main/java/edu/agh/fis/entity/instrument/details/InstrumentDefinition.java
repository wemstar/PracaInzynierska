package edu.agh.fis.entity.instrument.details;

import edu.agh.fis.entity.bra.acc.InstrumentInfo;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wemstar on 29.09.14.
 */
@Entity
@Table(name = "INSTRUMENT_DEFINITION")
public class InstrumentDefinition {


    @OneToMany(mappedBy = "instrumentDefinition")
    private Set<InstrumentInfo> instrumentInfos;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instrument")
    private Set<InstrumentMarket> markets;
    @Id
    @Column(name = "INSTRUMENT_ISIN")
    private String isin;

    public Set<InstrumentMarket> getMarkets() {
        return markets;
    }

    public void setMarkets(Set<InstrumentMarket> markets) {
        this.markets = markets;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }


    public Set<InstrumentInfo> getInstrumentInfos() {
        return instrumentInfos;
    }

    public void setInstrumentInfos(Set<InstrumentInfo> instrumentInfos) {
        this.instrumentInfos = instrumentInfos;
    }


}
