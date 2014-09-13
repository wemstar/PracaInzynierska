package edu.agh.fis.client.file.application;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.client.file.services.ClientFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wemstar on 06.09.14.
 */
@RestController
@RequestMapping("/client/file")
public class ClientFileREST {


    @Autowired
    private ClientFileService clientFileService;

    @RequestMapping(value = "/{clientNo}",method = RequestMethod.GET)
    @Transactional
    public ClientFile getClientFile(@PathVariable long clientNo)
    {
        return clientFileService.getByClientNo(clientNo);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ClientFile createClientFile(ClientFile clientFile )
    {

        clientFileService.createClient(clientFile);
        return clientFile;
    }


}
