package edu.agh.fis.core.bra.acc.services;

import edu.agh.fis.entity.bra.acc.BraAccount;

/**
 * Dostarcza logikę dla rachunku klienta
 */
public interface BraAccountServices {
    BraAccount getBraAcc(long braNo);

    void updateBraAcc(BraAccount braAccount);

    BraAccount createBraAcc(BraAccount braAccount);

    void deleteBraAcc(long braNo);

    BraAccount addAccountToClient(long clientNo, BraAccount braAccount);
}
