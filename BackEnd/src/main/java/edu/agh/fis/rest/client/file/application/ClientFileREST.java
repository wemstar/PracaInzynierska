package edu.agh.fis.rest.client.file.application;

import edu.agh.fis.client.file.ClientFileTransport;
import edu.agh.fis.entity.client.file.ClientFile;

/**
 * Created by wemstar on 13.09.14.
 */
public interface ClientFileREST {

    ClientFileTransport getClientFile(long clientNo);


    ClientFile createClientFile(ClientFile clientFile);
}
