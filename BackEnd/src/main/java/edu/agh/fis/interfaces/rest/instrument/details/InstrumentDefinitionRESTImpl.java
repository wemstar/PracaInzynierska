package edu.agh.fis.interfaces.rest.instrument.details;

import edu.agh.fis.core.instrument.details.services.InstrumentDefinitionService;
import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wemstar on 25.09.14.
 */
@RequestMapping("/instrument/details")
@RestController

public class InstrumentDefinitionRESTImpl implements InstrumentDefinitionREST {

    @Autowired
    private InstrumentDefinitionService instrumentDefinitionService;

    @Autowired
    private InstrumentDefinitionTransformer instrumentDefinitionTransformer;

    @Override
    @RequestMapping(value = "/{isin}", method = RequestMethod.GET)
    public InstrumentDefinitionDTO getInstrumentInfo(@PathVariable String isin) {

        return instrumentDefinitionTransformer.entityToTransport(instrumentDefinitionService.getInstrumentInfo(isin));
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InstrumentDefinitionDTO createInstrumentInfo(@RequestBody InstrumentDefinitionDTO instrumentdefinitionDTO) {
        return instrumentDefinitionTransformer.entityToTransport(instrumentDefinitionService.createInstrumentDetails(instrumentDefinitionTransformer.transportToEntity(instrumentdefinitionDTO)));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInstrumentInfo(@RequestBody InstrumentDefinitionDTO instrumentdefinitionDTO) {

        instrumentDefinitionService.updateInstrumentInfo(instrumentDefinitionTransformer.transportToEntity(instrumentdefinitionDTO));

    }

    @Override
    @RequestMapping(value = "/{isin}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstrumentInfo(@PathVariable String isin) {

        instrumentDefinitionService.deleteInstrumentInfo(isin);

    }
}
