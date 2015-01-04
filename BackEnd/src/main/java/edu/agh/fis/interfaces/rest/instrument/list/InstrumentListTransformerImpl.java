package edu.agh.fis.interfaces.rest.instrument.list;

import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.instrument.list.InstrumentListDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static edu.agh.fis.builder.instrument.list.InstrumentListDetailsDTOBuilder.anInstrumentListDetailsDTO;

/**
 * Created by wemstar on 21.12.14.
 */
@Component
public class InstrumentListTransformerImpl implements InstrumentListTransformer {

    @Autowired
    private InstrumentHistoryTransform transformerHistory;

    @Override
    public List<InstrumentListDetailsDTO> entityToTranportList(List<InstrumentMarket> instruments) {
        List<InstrumentListDetailsDTO> transport = new ArrayList<InstrumentListDetailsDTO>();
        for (InstrumentMarket instrument : instruments) transport.add(entityToTransport(instrument));
        return transport;
    }

    @Override
    public InstrumentListDetailsDTO entityToTransport(InstrumentMarket instrument) {
        return anInstrumentListDetailsDTO()
                .buyPrice(instrument.getBuyPrice())
                .sellPrice(instrument.getSellPrice())
                .isin(instrument.getInstrument().getIsin())
                .name(instrument.getInstrument().getName())
                .market(instrument.getMarket().getCode())
                .historyList(transformerHistory.entityToTransportList(instrument.getHistory()))
                .build();
    }
}
