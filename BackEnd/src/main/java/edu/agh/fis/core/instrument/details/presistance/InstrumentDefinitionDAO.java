package edu.agh.fis.core.instrument.details.presistance;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.utils.presistance.AbstractDAO;

/**
 * Wyciąga InstrumentDefinition z bazy danych
 * @see edu.agh.fis.entity.instrument.details.InstrumentDefinition
 */
public interface InstrumentDefinitionDAO extends AbstractDAO<InstrumentDefinition> {

    /**
     * Usuwa instrument po ISIN
     *
     * @param isin ISIN
     */
    void delete(String isin);

    InstrumentDefinition find(String isin);
}
