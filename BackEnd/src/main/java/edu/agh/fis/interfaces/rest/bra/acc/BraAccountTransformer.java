package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;

/**
 * Transformuje obiekty transportowe in bazodanowe
 */
public interface BraAccountTransformer {
    BraAccountDTO entityToTransport(BraAccount braAcc);

    BraAccount transportToEntity(BraAccountDTO braAccountDTO);
}
