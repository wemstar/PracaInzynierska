package edu.agh.fis.core.instrument.list.service;

import edu.agh.fis.core.bra.acc.presistance.BraAccountDao;
import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
@Service
public class InstrumentListServiceImpl implements InstrumentListService {

    @Autowired
    private BraAccountDao braAccountDao;

    @Autowired
    private MarketDAO marketDao;


    @Override
    public List<InstrumentMarket> getInstrument(long braAccNo) {
        List<InstrumentMarket> list = new ArrayList<InstrumentMarket>();
        for (InstrumentInfo info : braAccountDao.find(braAccNo).getInstruments())
            list.addAll(info.getInstrumentDefinition().getMarkets());

        return list;
    }

    @Override
    public List<InstrumentMarket> getAllInstrument() {
        List<InstrumentMarket> list = new ArrayList<InstrumentMarket>();
        for (Markets market : marketDao.getActiveMarkets())
            list.addAll(market.getInstruments());
        return list;
    }
}
