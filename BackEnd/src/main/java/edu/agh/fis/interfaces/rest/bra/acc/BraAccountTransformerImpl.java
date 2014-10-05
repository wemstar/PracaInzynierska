package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountTransport;
import edu.agh.fis.entity.bra.acc.BraAccount;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 29.09.14.
 */
@Component
public class BraAccountTransformerImpl implements BraAccountTransformer {
    @Override
    public BraAccountTransport entityToTransport(BraAccount braAcc) {

        BraAccountTransport transport=new BraAccountTransport();
        if(braAcc !=null) {
            transport.braAccNo = braAcc.id;
        }
        return transport;
    }

    @Override
    public BraAccount transportToEntity(BraAccountTransport braAccountTransport) {
        BraAccount entity=new BraAccount();
        entity.id=braAccountTransport.braAccNo;
        return entity;
    }
}
