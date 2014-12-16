package edu.agh.fis.builder.entity.instrument.details;

import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

import java.util.Set;

/**
 * Created by wemstar on 11.10.14.
 */
public class InstrumentDefinitionBuilder {
    private Set<InstrumentInfo> instrumentInfos;
    private String isin;
    private String name;

    private InstrumentDefinitionBuilder() {
    }

    public static InstrumentDefinitionBuilder anInstrumentDefinition() {
        return new InstrumentDefinitionBuilder();
    }

    public InstrumentDefinitionBuilder id(long id) {
        return this;
    }

    InstrumentDefinitionBuilder instrumentInfos(Set<InstrumentInfo> instrumentInfos) {
        this.instrumentInfos = instrumentInfos;
        return this;
    }

    public InstrumentDefinitionBuilder isin(String isin) {
        this.isin = isin;
        return this;
    }

    public InstrumentDefinitionBuilder name(String name) {
        this.name = name;
        return this;
    }

    public InstrumentDefinitionBuilder but() {
        return anInstrumentDefinition().instrumentInfos(instrumentInfos).isin(isin);
    }

    public InstrumentDefinition build() {
        InstrumentDefinition instrumentDefinition = new InstrumentDefinition();
        instrumentDefinition.setInstrumentInfos(instrumentInfos);
        instrumentDefinition.setIsin(isin);
        instrumentDefinition.setName(name);
        return instrumentDefinition;
    }
}
