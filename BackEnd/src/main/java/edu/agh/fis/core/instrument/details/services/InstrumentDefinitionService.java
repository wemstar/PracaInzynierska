package edu.agh.fis.core.instrument.details.services;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

/**
 * Logika biznesowa przetwarzające definicję instrumentów
 */
public interface InstrumentDefinitionService {
    InstrumentDefinition getInstrumentInfo(String isin);

    InstrumentDefinition createInstrumentDetails(InstrumentDefinition instrumentDefinition);

    void updateInstrumentInfo(InstrumentDefinition instrumentDefinition);

    void deleteInstrumentInfo(String isin);
}
