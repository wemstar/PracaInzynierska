package edu.agh.fis.utils.transform;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.client.file.ClientFile;

import java.util.HashSet;
import java.util.Set;

import static edu.agh.fis.builder.entity.bra.acc.BraAccountBuilder.aBraAccount;
import static edu.agh.fis.builder.entity.bra.acc.InstrumentInfoBuilder.anInstrumentInfo;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;

/**
 * Created by wemstar on 11.10.14.
 */
public class TransformFromDTO {


    public static Set<BraAccount> braAccounts(Set<BraAccountDTO> setDto, ClientFile clientFile) {
        Set<BraAccount> setEntity = new HashSet<BraAccount>();
        for (BraAccountDTO dto : setDto) {
            BraAccount braAccount = aBraAccount()
                    .id(dto.getBraAccNo())
                    .avalibleCash(dto.getAvalibleCash())
                    .blockCash(dto.getBlockCash())
                    .clientFile(clientFile)
                    .build();
            braAccount.setInstruments(instrumentInfos(dto.getInstruments(), braAccount));
            setEntity.add(braAccount);

        }
        return setEntity;

    }

    public static Set<InstrumentInfo> instrumentInfos(Set<InstrumentInfoDTO> setDto, BraAccount braAccount) {
        Set<InstrumentInfo> setEntity = new HashSet<InstrumentInfo>();
        for (InstrumentInfoDTO dto : setDto) {
            setEntity.add(anInstrumentInfo()
                    .instrumentDefinition(
                            anInstrumentDefinition()
                                    .isin(dto.getInstrument().getIsin())
                                    .build())
                    .ammount(dto.getAmmount())
                    .blocked(dto.getBlocked())
                    .braAccount(braAccount)
                    .build());
        }
        return setEntity;

    }

}
