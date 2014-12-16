package edu.agh.fis.builder.instrument.details;

import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

/**
 * Created by wemstar on 16.12.14.
 */
public class InstrumentDefinitionDTOBuilder {
    private String isin;
    private String name;

    private InstrumentDefinitionDTOBuilder() {
    }

    public static InstrumentDefinitionDTOBuilder anInstrumentDefinitionDTO() {
        return new InstrumentDefinitionDTOBuilder();
    }

    public InstrumentDefinitionDTOBuilder isin(String isin) {
        this.isin = isin;
        return this;
    }

    public InstrumentDefinitionDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public InstrumentDefinitionDTOBuilder but() {
        return anInstrumentDefinitionDTO().isin(isin).name(name);
    }

    public InstrumentDefinitionDTO build() {
        InstrumentDefinitionDTO instrumentDefinitionDTO = new InstrumentDefinitionDTO();
        instrumentDefinitionDTO.setIsin(isin);
        instrumentDefinitionDTO.setName(name);
        return instrumentDefinitionDTO;
    }
}
