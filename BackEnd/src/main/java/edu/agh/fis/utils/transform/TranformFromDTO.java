package edu.agh.fis.utils.transform;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;

import java.util.HashSet;
import java.util.Set;

import static edu.agh.fis.builder.entity.bra.acc.BraAccountBuilder.aBraAccount;
import static edu.agh.fis.builder.entity.bra.acc.InstrumentInfoBuilder.anInstrumentInfo;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;

/**
 * Created by wemstar on 11.10.14.
 */
public class TranformFromDTO {


    public static Set<BraAccount> braAccounts(Set<BraAccountDTO> setDto)
    {
        Set<BraAccount> setEntity=new HashSet<BraAccount>();
        for(BraAccountDTO dto:setDto)
        {
            setEntity.add(aBraAccount()
                    .id(dto.getBraAccNo())
                    .balance(dto.getBalance())
                    .instruments(instrumentInfos(dto.getInstruments()))
                    .build());
        }
        return setEntity;

    }

    public static Set<InstrumentInfo> instrumentInfos(Set<InstrumentInfoDTO> setDto)
    {
        Set<InstrumentInfo> setEntity=new HashSet<InstrumentInfo>();
        for(InstrumentInfoDTO dto:setDto)
        {
            setEntity.add(anInstrumentInfo()
                    .instrumentDefinition(
                            anInstrumentDefinition()
                                    .isin(dto.getDefinition().getIsin())
                                    .build())
                    .quantity(dto.getQuantity())
                    .build());
        }
        return setEntity;

    }

}
