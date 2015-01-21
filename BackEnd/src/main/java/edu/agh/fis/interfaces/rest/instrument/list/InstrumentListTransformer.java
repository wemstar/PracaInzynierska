package edu.agh.fis.interfaces.rest.instrument.list;

import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.instrument.list.InstrumentListDetailsDTO;

import java.util.List;

/**
 * Transformuje obiekty transportowe i bazodanowe
 */
public interface InstrumentListTransformer {


    List<InstrumentListDetailsDTO> entityToTranportList(List<InstrumentMarket> instrument);

    InstrumentListDetailsDTO entityToTransport(InstrumentMarket instrument);
}
