package edu.agh.fis.core.client.file.services;

import edu.agh.fis.entity.client.file.ClientFile;

import java.util.List;

/**
 * Implementacja logiki dla Kartoteki klienta
 */
public interface ClientFileService {

    ClientFile getByClientNo(long clientNo);

    ClientFile createClientFile(ClientFile clientFile);

    void updateClientFile(ClientFile clientFile);

    void deleteClientFile(long clientNo);

    List<ClientFile> getByTemplate(ClientFile template);
}
