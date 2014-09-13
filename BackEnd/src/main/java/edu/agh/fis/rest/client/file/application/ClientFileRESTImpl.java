package edu.agh.fis.rest.client.file.application;

import edu.agh.fis.client.file.ClientFileTransport;
import edu.agh.fis.client.file.services.ClientFileService;
import edu.agh.fis.entity.client.file.ClientFile;
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
    ClientFile createClientFile(ClientFile clientFile) {

        clientFileService.createClient(clientFile);
        return clientFile;
    }


}
