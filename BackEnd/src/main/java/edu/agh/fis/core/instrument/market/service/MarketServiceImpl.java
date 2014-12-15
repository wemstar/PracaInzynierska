package edu.agh.fis.core.instrument.market.service;

import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.instrument.details.Markets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketDAO marketDAO;


    @Override
    public List<Markets> getActiveMarket() {
        return marketDAO.getActiveMarkets();

    }
}
