package edu.agh.fis.core.trader.blocker;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

/**
 * Blokuje zasoby na rachunku
 */
public interface AccountBlocked {

    /**
     * blokuje instrumenty na rachunku
     *
     * @param account    rachunek
     * @param definition instrument
     * @param amount     ilośc
     */
    void blockInstrument(BraAccount account, InstrumentDefinition definition, Long amount);

    /**
     * blokuje gotówkę na rachunku
     * @param account rachunek
     * @param blockedCash gotówka
     */
    void blockCahs(BraAccount account, Double blockedCash);

    /**
     * zwalnia zablokowaną gotówkę
     * @param account rachunek
     * @param blockedCash gotówka
     */
    void freeCash(BraAccount account, Double blockedCash);

    /**
     * zwalnia blokadę na instrumentach
     * @param account rachunek
     * @param definition instrument
     * @param amount ilośc
     */
    void freeInstrument(BraAccount account, InstrumentDefinition definition, Long amount);
}
