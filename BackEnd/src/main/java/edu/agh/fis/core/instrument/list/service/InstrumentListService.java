package edu.agh.fis.core.instrument.list.service;

import edu.agh.fis.entity.instrument.details.InstrumentMarket;

import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
public interface InstrumentListService {

    List<InstrumentMarket> getInstrument(long braAccNo);

    List<InstrumentMarket> getAllInstrument();
}
