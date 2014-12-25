package edu.agh.fis.interfaces.rest.instrument.list;

import edu.agh.fis.entity.instrument.details.InstrumentHistory;
import edu.agh.fis.instrument.list.InstrumentHistoryDTO;

import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
public interface InstrumentHistoryTransform {
    List<InstrumentHistoryDTO> entityToTransportList(List<InstrumentHistory> history);

    InstrumentHistoryDTO entityToTransport(InstrumentHistory history);
}
