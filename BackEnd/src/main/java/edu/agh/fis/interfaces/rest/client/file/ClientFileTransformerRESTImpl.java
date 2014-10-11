package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.builder.bra.acc.BraAccountDTOBuilder;
import edu.agh.fis.builder.client.file.ClientFileDTOBuilder;
import edu.agh.fis.client.file.ClientFileDTO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.utils.transform.TranformFromDTO;
import edu.agh.fis.utils.transform.TransformFromEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static edu.agh.fis.builder.client.file.ClientFileDTOBuilder.aClientFileTransport;
import static edu.agh.fis.builder.entity.bra.acc.BraAccountBuilder.aBraAccount;
import static edu.agh.fis.builder.entity.bra.acc.InstrumentInfoBuilder.anInstrumentInfo;
import static edu.agh.fis.builder.entity.client.file.ClientFileBuilder.aClientFile;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;

/**
 * Created by wemstar on 02.10.14.
 */
@Component
public class ClientFileTransformerRESTImpl implements ClientFileTransformerREST {


    @Override
    public ClientFile transportToEntity(ClientFileDTO clientFile) {

        return aClientFile()
                .pesel(clientFile.getPesel())
                .clientNo(clientFile.getClientNo())
                .name(clientFile.getName())
                .surname(clientFile.getSurname())
                .dateOfBirth(clientFile.getDateOfBirth())
                .account(TranformFromDTO.braAccounts(clientFile.getAccounts()))
                .build();
    }

    @Override
    public ClientFileDTO entityToTransport(ClientFile clientFile) {

        return aClientFileTransport()
                .pesel(clientFile.getPesel())
                .clientNo(clientFile.getClientNo())
                .dateOfBirth(clientFile.getDateOfBirth())
                .name(clientFile.getName())
                .surname(clientFile.getSurname())
                .accounts(TransformFromEntity.braAccounts(clientFile.getAccount()))
                .build();
    }


}
