package edu.agh.fis.rest.client.file.application;

import edu.agh.fis.client.file.ClientFileTransport;
import edu.agh.fis.entity.client.file.ClientFile;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wemstar on 13.09.14.
 */
public interface ClientFileREST {

    ClientFileTransport getClientFile(long clientNo);


    ClientFile createClientFile(ClientFile clientFile);
}
