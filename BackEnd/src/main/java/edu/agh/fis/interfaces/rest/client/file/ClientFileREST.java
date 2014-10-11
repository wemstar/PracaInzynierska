package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileDTO;

/**
 * Created by wemstar on 13.09.14.
 */
public interface ClientFileREST {

    ClientFileDTO getClientFile(long clientNo);


    ClientFileDTO createClientFile(ClientFileDTO clientFile);

    void updateClientFile(ClientFileDTO transport);

    void deleteClientFile(long clientNo);
}
