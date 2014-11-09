package edu.agh.fis.core.instrument.details.services;

import edu.agh.fis.core.instrument.details.presistance.InstrumentDefinitionDAO;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wemstar on 29.09.14.
 */
@Service
public class InstrumentDefinitionServiceImpl implements InstrumentDefinitionService {

    @Autowired
    InstrumentDefinitionDAO instrumentDefinitionDAO;

    @Override
    public InstrumentDefinition getInstrumentInfo(String isin) {
        return instrumentDefinitionDAO.find(isin);
    }

    @Override
    public InstrumentDefinition createInstrumentDetails(InstrumentDefinition instrumentDefinition) {
        return instrumentDefinitionDAO.create(instrumentDefinition);
    }

    @Override
    public void updateInstrumentInfo(InstrumentDefinition instrumentDefinition) {
        instrumentDefinitionDAO.update(instrumentDefinition);
    }

    @Override
    public void deleteInstrumentInfo(String isin) {
        instrumentDefinitionDAO.delete(isin);

    }
}
