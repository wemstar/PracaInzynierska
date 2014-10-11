package edu.agh.fis.core.client.file.services;

import edu.agh.fis.entity.client.file.ClientFile;

/**
 * Created by wemstar on 29.09.14.
 */
public interface ClientFileService {

    ClientFile getByClientNo(long clientNo);

    ClientFile createClientFile(ClientFile clientFile);

    void updateClientFile(ClientFile clientFile);

    void deleteClientFile(long clientNo);
}
