package edu.agh.fis.core.bra.acc.services;

import edu.agh.fis.entity.bra.acc.BraAccount;

/**
 * Created by wemstar on 25.09.14.
 */
public interface BraAccountServices {
    BraAccount getBraAcc(long braNo);

    void updateBraAcc(BraAccount braAccount);

    BraAccount createBraAcc(BraAccount braAccount);

    void deleteBraAcc(long braNo);
}
