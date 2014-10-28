package edu.agh.fis.interfaces.rest.instrument.details;


import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

/**
 * Created by wemstar on 25.09.14.
 */
public interface InstrumentDefinitionREST {


    public InstrumentDefinitionDTO getInstrumentInfo(String isin);

    public InstrumentDefinitionDTO createInstrumentInfo(InstrumentDefinitionDTO instrumentInfoDTO);

    public void updateInstrumentInfo(InstrumentDefinitionDTO instrumentInfoDTO);

    public void deleteInstrumentInfo(String isin);
}
