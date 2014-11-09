package edu.agh.fis.utils.transform;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;

import java.util.HashSet;
import java.util.Set;

import static edu.agh.fis.builder.bra.acc.BraAccountDTOBuilder.aBraAccountTransport;
import static edu.agh.fis.builder.bra.acc.InstrumentInfoDTOBuilder.anInstrumentInfoTransport;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionTransportBuilder.anInstrumentDefinitionTransport;

/**
 * Created by wemstar on 11.10.14.
 */
public class TransformFromEntity {


    public static Set<BraAccountDTO> braAccounts(Set<BraAccount> setEntity) {
        Set<BraAccountDTO> setDto = new HashSet<BraAccountDTO>();
        for (BraAccount entity : setEntity) {
            setDto.add(aBraAccountTransport()
                    .braAccNo(entity.getId())
                    .balance(entity.getBalance())
                    .instruments(instrumentInfos(entity.getInstruments()))
                    .build());
        }

        return setDto;

    }

    public static Set<InstrumentInfoDTO> instrumentInfos(Set<InstrumentInfo> setEntity) {
        Set<InstrumentInfoDTO> setDto = new HashSet<InstrumentInfoDTO>();
        for (InstrumentInfo entity : setEntity) {
            setDto.add(anInstrumentInfoTransport()
                    .definition(anInstrumentDefinitionTransport()
                            .isin(entity.getInstrumentDefinition().getIsin())
                            .build())
                    .quantity(entity.getQuantity())
                    .build());
        }
        return setDto;

    }
}
