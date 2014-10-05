package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileTransport;
import edu.agh.fis.entity.client.file.ClientFile;
import org.springframework.stereotype.Component;

/**
 * Created by wemstar on 02.10.14.
 */
@Component
public class ClientFileTransformerRESTImpl implements ClientFileTransformerREST {


    @Override
    public ClientFile transportToEntity(ClientFileTransport clientFile) {
        return null;
    }

    @Override
    public ClientFileTransport entityToTransport(ClientFile clientFile) {
        return null;
    }
}
