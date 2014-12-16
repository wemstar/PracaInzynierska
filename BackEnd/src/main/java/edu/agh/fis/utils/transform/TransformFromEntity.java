package edu.agh.fis.utils.transform;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;

import java.util.HashSet;
import java.util.Set;

import static edu.agh.fis.builder.bra.acc.BraAccountDTOBuilder.aBraAccountDTO;
import static edu.agh.fis.builder.bra.acc.InstrumentInfoDTOBuilder.anInstrumentInfoDTO;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionDTOBuilder.anInstrumentDefinitionDTO;


/**
 * Created by wemstar on 11.10.14.
 */
public class TransformFromEntity {


    public static Set<BraAccountDTO> braAccounts(Set<BraAccount> setEntity) {
        Set<BraAccountDTO> setDto = new HashSet<BraAccountDTO>();
        for (BraAccount entity : setEntity) {
            setDto.add(aBraAccountDTO()
                    .braAccNo(entity.getId())
                    .avalibleCash(entity.getAvalibleCash())
                    .blockCash(entity.getBlockCash())
                    .instruments(instrumentInfos(entity.getInstruments()))
                    .build());
        }

        return setDto;

    }

    public static Set<InstrumentInfoDTO> instrumentInfos(Set<InstrumentInfo> setEntity) {
        Set<InstrumentInfoDTO> setDto = new HashSet<InstrumentInfoDTO>();
        for (InstrumentInfo entity : setEntity) {
            setDto.add(anInstrumentInfoDTO()
                    .instrument(anInstrumentDefinitionDTO()
                            .isin(entity.getInstrumentDefinition().getIsin())
                            .name(entity.getInstrumentDefinition().getName())
                            .build())
                    .ammount(entity.getAmmount())
                    .blocked(entity.getBlocked())
                    .build());
        }
        return setDto;

    }
}
