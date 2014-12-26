package edu.agh.fis.interfaces.rest.instrument.list;

import edu.agh.fis.instrument.list.InstrumentListDetailsDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
public interface InstrumentListREST {


    public List<InstrumentListDetailsDTO> getInstrumentForAccount(long accountNo);

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    List<InstrumentListDetailsDTO> getAllInstruments();
}
