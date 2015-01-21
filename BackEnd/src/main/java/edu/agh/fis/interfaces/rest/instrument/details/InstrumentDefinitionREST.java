package edu.agh.fis.interfaces.rest.instrument.details;


import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Przetwarza zapytanie REST dla Instrumentu
 */
public interface InstrumentDefinitionREST {


    public InstrumentDefinitionDTO getInstrumentInfo(String isin);

    public InstrumentDefinitionDTO createInstrumentInfo(InstrumentDefinitionDTO instrumentInfoDTO);

    public void updateInstrumentInfo(InstrumentDefinitionDTO instrumentInfoDTO);

    public void deleteInstrumentInfo(String isin);

    @RequestMapping("/update/history")
    void updateHistory();
}
