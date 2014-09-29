package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileTransport;
import edu.agh.fis.core.client.file.services.ClientFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wemstar on 06.09.14.
 */
@RestController
@RequestMapping("/client/file")
public class ClientFileRESTImpl implements ClientFileREST {


    @Autowired
    private ClientFileService clientFileService;

    @Override
    @RequestMapping(value = "/{clientNo}", method = RequestMethod.GET)
    public ClientFileTransport getClientFile(@PathVariable long clientNo) {
        return new ClientFileTransport(clientFileService.getByClientNo(clientNo));
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public
    @ResponseBody
    ClientFileTransport createClientFile(ClientFileTransport clientFile) {


        return clientFile;
    }

    @Override
    public ClientFileTransport updateClientFile(ClientFileTransport clientFile) {
        return null;
    }

    @Override
    public int deleteClientFile(long clientNo) {
        return 0;
    }


}
