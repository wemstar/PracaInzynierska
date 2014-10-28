package edu.agh.fis.core.instrument.details.services;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

/**
 * Created by wemstar on 29.09.14.
 */
public interface InstrumentDefinitionService {
    InstrumentDefinition getInstrumentInfo(String isin);

    InstrumentDefinition createInstrumentDetails(InstrumentDefinition instrumentDefinition);

    void updateInstrumentInfo(InstrumentDefinition instrumentDefinition);

    void deleteInstrumentInfo(String isin);
}
