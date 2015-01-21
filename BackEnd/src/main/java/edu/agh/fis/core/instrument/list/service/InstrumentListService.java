package edu.agh.fis.core.instrument.list.service;

import edu.agh.fis.entity.instrument.details.InstrumentMarket;

import java.util.List;

/**
 * Obsługuje pobieranie listy instrumentów
 */
public interface InstrumentListService {

    List<InstrumentMarket> getInstrument(long braAccNo);

    List<InstrumentMarket> getAllInstrument();
}
