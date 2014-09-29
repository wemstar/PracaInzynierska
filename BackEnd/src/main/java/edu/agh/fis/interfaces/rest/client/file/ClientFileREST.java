package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileTransport;

/**
 * Created by wemstar on 13.09.14.
 */
public interface ClientFileREST {

    ClientFileTransport getClientFile(long clientNo);


    ClientFileTransport createClientFile(ClientFileTransport clientFile);

    ClientFileTransport updateClientFile(ClientFileTransport clientFile);

    int deleteClientFile(long clientNo);
}
