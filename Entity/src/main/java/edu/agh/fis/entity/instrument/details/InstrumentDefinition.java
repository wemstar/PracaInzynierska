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
    public Set<InstrumentInfo> instrumentInfos;

    @Id
    @Column(name = "INSTRUMENT_ISIN")
    public String isin;

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
