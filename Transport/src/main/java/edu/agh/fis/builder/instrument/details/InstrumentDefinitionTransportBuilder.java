package edu.agh.fis.builder.instrument.details;

import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

/**
 * Created by wemstar on 11.10.14.
 */
public class InstrumentDefinitionTransportBuilder {
    public String isin;

    private InstrumentDefinitionTransportBuilder() {
    }

    public static InstrumentDefinitionTransportBuilder anInstrumentDefinitionTransport() {
        return new InstrumentDefinitionTransportBuilder();
    }

    public InstrumentDefinitionTransportBuilder isin(String isin) {
        this.isin = isin;
        return this;
    }

    public InstrumentDefinitionTransportBuilder but() {
        return anInstrumentDefinitionTransport().isin(isin);
    }

    public InstrumentDefinitionDTO build() {
        InstrumentDefinitionDTO instrumentDefinitionDTO = new InstrumentDefinitionDTO();
        instrumentDefinitionDTO.setIsin(isin);
        return instrumentDefinitionDTO;
    }
}
