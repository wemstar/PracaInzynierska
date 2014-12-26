package edu.agh.fis.interfaces.rest.instrument.list;

import edu.agh.fis.core.instrument.list.service.InstrumentListService;
import edu.agh.fis.instrument.list.InstrumentListDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
@RestController
@RequestMapping("/instrument/list")
public class InstrumentListRESTImpl implements InstrumentListREST {

    @Autowired
    InstrumentListService service;

    @Autowired
    InstrumentListTransformer transformer;

    @Override
    @RequestMapping(value = "/bra/account/{accountNo}", method = RequestMethod.GET)
    public List<InstrumentListDetailsDTO> getInstrumentForAccount(@PathVariable long accountNo) {


        return transformer.entityToTranportList(service.getInstrument(accountNo));
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<InstrumentListDetailsDTO> getAllInstruments() {
        return transformer.entityToTranportList(service.getAllInstrument());
    }


}
