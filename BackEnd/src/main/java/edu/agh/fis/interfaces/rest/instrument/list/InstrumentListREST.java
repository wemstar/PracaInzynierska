package edu.agh.fis.interfaces.rest.instrument.list;

import edu.agh.fis.instrument.list.InstrumentListDetailsDTO;

import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
public interface InstrumentListREST {


    public List<InstrumentListDetailsDTO> getInstrumentForAccount(long accountNo);
}
