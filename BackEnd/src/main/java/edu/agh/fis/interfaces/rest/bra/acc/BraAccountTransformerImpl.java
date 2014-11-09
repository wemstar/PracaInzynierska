package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.utils.transform.TransformFromDTO;
import edu.agh.fis.utils.transform.TransformFromEntity;
import org.springframework.stereotype.Component;

import static edu.agh.fis.builder.bra.acc.BraAccountDTOBuilder.aBraAccountTransport;
import static edu.agh.fis.builder.entity.bra.acc.BraAccountBuilder.aBraAccount;

/**
 * Created by wemstar on 29.09.14.
 */
@Component
public class BraAccountTransformerImpl implements BraAccountTransformer {
    @Override
    public BraAccountDTO entityToTransport(BraAccount braAcc) {

        if (braAcc == null) return null;
        BraAccountDTO transport = aBraAccountTransport()
                .braAccNo(braAcc.getId())
                .balance(braAcc.getBalance())
                .instruments(TransformFromEntity.instrumentInfos(braAcc.getInstruments()))
                .build();

        return transport;
    }

    @Override
    public BraAccount transportToEntity(BraAccountDTO braAccountDTO) {
        BraAccount entity = aBraAccount()
                .id(braAccountDTO.getBraAccNo())
                .balance(braAccountDTO.getBalance())
                .build();

        entity.setInstruments(TransformFromDTO.instrumentInfos(braAccountDTO.getInstruments(), entity));

        return entity;
    }
}
