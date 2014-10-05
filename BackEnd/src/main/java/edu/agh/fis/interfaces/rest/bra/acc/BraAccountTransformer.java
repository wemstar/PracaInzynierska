package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountTransport;
import edu.agh.fis.entity.bra.acc.BraAccount;

/**
 * Created by wemstar on 05.10.14.
 */
public interface BraAccountTransformer {
    BraAccountTransport entityToTransport(BraAccount braAcc);

    BraAccount transportToEntity(BraAccountTransport braAccountTransport);
}
