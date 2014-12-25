package edu.agh.fis.core.trader.history;

import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.instrument.details.InstrumentHistory;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static edu.agh.fis.builder.entity.instrument.details.InstrumentHistoryBuilder.anInstrumentHistory;

/**
 * Created by wemstar on 24.12.14.
 */
@Service
public class HistoryScheduleImpl implements HistorySchedule {

    @Autowired
    private MarketDAO marketDAO;


    @Override
    public void calculateHistory() {
        List<Markets> markets = marketDAO.getActiveMarkets();
        for (Markets market : markets) {
            for (InstrumentMarket insmark : market.getInstruments()) {
                List<InstrumentHistory> historyList = insmark.getHistory();


                historyList.add(anInstrumentHistory()
                        .instrumentMarket(insmark)
                        .openPrice(historyList.size() > 0 ? historyList.get(historyList.size() - 1).getOpenPrice() : 0.0)
                        .closePrice(insmark.getSellPrice())
                        .minPrice(insmark.getMinPrice())
                        .maxPrice(insmark.getMaxPrice())
                        .date(new Date())
                        .build());
                insmark.setHistory(historyList);
            }

            marketDAO.update(market);
        }

    }
}
