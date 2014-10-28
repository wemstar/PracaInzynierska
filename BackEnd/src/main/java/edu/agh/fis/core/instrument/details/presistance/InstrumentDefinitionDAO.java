package edu.agh.fis.core.instrument.details.presistance;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.utils.presistance.AbstractDAO;

/**
 * Created by wemstar on 29.09.14.
 */
public interface InstrumentDefinitionDAO extends AbstractDAO<InstrumentDefinition> {
    void delete(String isin);

    InstrumentDefinition find(String isin);
}
