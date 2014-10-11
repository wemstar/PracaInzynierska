package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 29.09.14.
 */
@Component
public class BraAccountTransformerImpl implements BraAccountTransformer {
    @Override
    public BraAccountDTO entityToTransport(BraAccount braAcc) {

        BraAccountDTO transport = new BraAccountDTO();
        if (braAcc != null) {
            transport.braAccNo = braAcc.id;
        }
        return transport;
    }

    @Override
    public BraAccount transportToEntity(BraAccountDTO braAccountDTO) {
        BraAccount entity = new BraAccount();
        entity.id = braAccountDTO.braAccNo;
        return entity;
    }
}
