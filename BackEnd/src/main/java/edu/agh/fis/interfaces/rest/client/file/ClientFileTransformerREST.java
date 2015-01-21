package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileDTO;
import edu.agh.fis.entity.client.file.ClientFile;

import java.util.List;

/**
 * Transformuje obiekty transportowe in bazodanowe
 */
public interface ClientFileTransformerREST {
    ClientFile transportToEntity(ClientFileDTO clientFile);

    ClientFileDTO entityToTransport(ClientFile clientFile);

    List<ClientFileDTO> entityToTransportList(List<ClientFile> byTemplate);
}
