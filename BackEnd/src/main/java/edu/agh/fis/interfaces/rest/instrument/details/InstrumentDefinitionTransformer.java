package edu.agh.fis.interfaces.rest.instrument.details;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionTransportBuilder.anInstrumentDefinitionTransport;

/**
 * Created by wemstar on 28.10.14.
 */
public interface InstrumentDefinitionTransformer {


    public InstrumentDefinitionDTO entityToTransport(InstrumentDefinition entity);
    public InstrumentDefinition transportToEntity(InstrumentDefinitionDTO transport);

}