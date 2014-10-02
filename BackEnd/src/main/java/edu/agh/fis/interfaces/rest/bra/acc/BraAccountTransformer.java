package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountTransport;
import edu.agh.fis.entity.bra.acc.BraAccount;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 29.09.14.
 */
@Component
public class BraAccountTransformer {
    public BraAccountTransport entityToTransport(BraAccount braAcc) {

        return null;
    }

    public BraAccount transportToEntity(BraAccountTransport braAccountTransport) {
        return null;
    }
}
