package edu.agh.fis.core.instrument.details.presistance;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.utils.presistance.AbstractDAOImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by wemstar on 29.09.14.
 */
@Repository
public class InstrumentDefinitionDAOImpl extends AbstractDAOImpl<InstrumentDefinition> implements InstrumentDefinitionDAO {


    @Override
    public void delete(String isin) {
        sessionFactory.getCurrentSession().delete(find(isin));
    }

    @Override
    public InstrumentDefinition find(String isin) {
        return (InstrumentDefinition) sessionFactory.getCurrentSession().get(InstrumentDefinition.class, isin);
    }
}
