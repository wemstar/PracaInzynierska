package edu.agh.fis.core.trader.blocker;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

/**
 * Created by wemstar on 11.01.15.
 */
public interface AccountBlocked {

    void blockInstrument(BraAccount account, InstrumentDefinition definition, Long amount);

    void blockCahs(BraAccount account, Double blockedCash);

    void freeCash(BraAccount account, Double blockedCash);

    void freeInstrument(BraAccount account, InstrumentDefinition definition, Long amount);
}
