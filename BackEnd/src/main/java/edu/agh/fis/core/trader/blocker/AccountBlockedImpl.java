package edu.agh.fis.core.trader.blocker;

import edu.agh.fis.core.bra.acc.presistance.BraAccountDao;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 11.01.15.
 */
@Component
public class AccountBlockedImpl implements AccountBlocked {

    @Autowired
    private BraAccountDao dao;

    @Override
    public void blockInstrument(BraAccount account, InstrumentDefinition definition, Long amount) {
        for (InstrumentInfo instrumentInfo : account.getInstruments())
            if (instrumentInfo.getInstrumentDefinition().getIsin().equals(definition.getIsin())) {
                instrumentInfo.setAmmount(instrumentInfo.getAmmount() - amount);
                instrumentInfo.setBlocked(amount);
            }
        dao.update(account);
    }

    @Override
    public void blockCahs(BraAccount account, Double blockedCash) {

        account.setAvalibleCash(account.getAvalibleCash() - blockedCash);
        account.setBlockCash(blockedCash);
        dao.update(account);
    }

    @Override
    public void freeCash(BraAccount account, Double blockedCash) {
        account.setBlockCash(account.getBlockCash() - blockedCash);
        dao.update(account);
    }

    @Override
    public void freeInstrument(BraAccount account, InstrumentDefinition definition, Long amount) {
        for (InstrumentInfo instrumentInfo : account.getInstruments())
            if (instrumentInfo.getInstrumentDefinition().getIsin().equals(definition.getIsin()))
                instrumentInfo.setBlocked(instrumentInfo.getBlocked() - amount);

        dao.update(account);
    }
}
