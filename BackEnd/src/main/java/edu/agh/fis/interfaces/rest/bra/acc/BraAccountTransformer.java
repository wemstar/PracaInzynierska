package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;

/**
 * Created by wemstar on 05.10.14.
 */
public interface BraAccountTransformer {
    BraAccountDTO entityToTransport(BraAccount braAcc);

    BraAccount transportToEntity(BraAccountDTO braAccountDTO);
}
