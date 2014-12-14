package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileDTO;
import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.utils.transform.TransformFromDTO;
import edu.agh.fis.utils.transform.TransformFromEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static edu.agh.fis.builder.client.file.ClientFileDTOBuilder.aClientFileTransport;
import static edu.agh.fis.builder.entity.client.file.ClientFileBuilder.aClientFile;

/**
 * Created by wemstar on 02.10.14.
 */
@Component
public class ClientFileTransformerRESTImpl implements ClientFileTransformerREST {


    @Override
    public ClientFile transportToEntity(ClientFileDTO clientFile) {

        ClientFile clientFile1E = aClientFile()
                .pesel(clientFile.getPesel())
                .clientNo(clientFile.getClientNo())
                .name(clientFile.getName())
                .surname(clientFile.getSurname())
                .dateOfBirth(clientFile.getDateOfBirth())
                .build();

        clientFile1E.setAccount(TransformFromDTO.braAccounts(clientFile.getAccounts(), clientFile1E));
        return clientFile1E;
    }

    @Override
    public ClientFileDTO entityToTransport(ClientFile clientFile) {

        return clientFile != null ? aClientFileTransport()
                .pesel(clientFile.getPesel())
                .clientNo(clientFile.getClientNo())
                .dateOfBirth(clientFile.getDateOfBirth())
                .name(clientFile.getName())
                .surname(clientFile.getSurname())
                .accounts(TransformFromEntity.braAccounts(clientFile.getAccount()))
                .build() : null;
    }

    @Override
    public List<ClientFileDTO> entityToTransportList(List<ClientFile> byTemplate) {

        List<ClientFileDTO> list = new ArrayList<ClientFileDTO>();
        for (ClientFile file : byTemplate) list.add(entityToTransport(file));
        return list;
    }


}
