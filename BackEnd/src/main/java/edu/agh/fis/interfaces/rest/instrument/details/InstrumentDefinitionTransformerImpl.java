package edu.agh.fis.interfaces.rest.instrument.details;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;
import org.springframework.stereotype.Component;

import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionTransportBuilder.anInstrumentDefinitionTransport;

/**
 * Created by wemstar on 28.10.14.
 */
@Component
public class InstrumentDefinitionTransformerImpl implements InstrumentDefinitionTransformer {

    @Override
    public InstrumentDefinitionDTO entityToTransport(InstrumentDefinition entity) {
        return entity != null ?
                anInstrumentDefinitionTransport()
                        .isin(entity.getIsin())
                        .build()
                : null;
    }

    @Override
    public InstrumentDefinition transportToEntity(InstrumentDefinitionDTO transport) {

        anInstrumentDefinition().isin(transport.getIsin()).build();
        return transport != null ?
                anInstrumentDefinition()
                        .isin(transport.getIsin())
                        .build()
                : null;
    }
}
