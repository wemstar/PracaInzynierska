package edu.agh.fis.builder.bra.acc;

import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

/**
 * Created by wemstar on 11.10.14.
 */
public class InstrumentInfoDTOBuilder {
    public InstrumentDefinitionDTO definition;
    public long quantity;

    private InstrumentInfoDTOBuilder() {
    }

    public static InstrumentInfoDTOBuilder anInstrumentInfoTransport() {
        return new InstrumentInfoDTOBuilder();
    }

    public InstrumentInfoDTOBuilder definition(InstrumentDefinitionDTO definition) {
        this.definition = definition;
        return this;
    }

    public InstrumentInfoDTOBuilder quantity(long quantity) {
        this.quantity = quantity;
        return this;
    }

    public InstrumentInfoDTOBuilder but() {
        return anInstrumentInfoTransport().definition(definition).quantity(quantity);
    }

    public InstrumentInfoDTO build() {
        InstrumentInfoDTO instrumentInfoDTO = new InstrumentInfoDTO();
        instrumentInfoDTO.setDefinition(definition);
        instrumentInfoDTO.setQuantity(quantity);
        return instrumentInfoDTO;
    }
}
