package edu.agh.fis.interfaces.rest.instrument.list;

import edu.agh.fis.entity.instrument.details.InstrumentHistory;
import edu.agh.fis.instrument.list.InstrumentHistoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static edu.agh.fis.builder.instrument.list.InstrumentHistoryDTOBuilder.anInstrumentHistoryDTO;

/**
 * Created by wemstar on 21.12.14.
 */
@Component
public class InstrumentHistoryTransformImpl implements InstrumentHistoryTransform {
    @Override
    public List<InstrumentHistoryDTO> entityToTransportList(List<InstrumentHistory> histories) {
        List<InstrumentHistoryDTO> transport = new ArrayList<InstrumentHistoryDTO>();
        for (InstrumentHistory history : histories) transport.add(entityToTransport(history));
        return transport;
    }

    @Override
    public InstrumentHistoryDTO entityToTransport(InstrumentHistory history) {
        return anInstrumentHistoryDTO()
                .date(history.getDate())
                .closePrice(history.getClosePrice())
                .maxPrice(history.getMaxPrice())
                .minPrice(history.getMinPrice())
                .openPrice(history.getOpenPrice())
                .build();
    }
}
