package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileTransport;
import edu.agh.fis.entity.client.file.ClientFile;

/**
 * Created by wemstar on 05.10.14.
 */
public interface ClientFileTransformerREST {
    ClientFile transportToEntity(ClientFileTransport clientFile);

    ClientFileTransport entityToTransport(ClientFile clientFile);
}
