package edu.agh.fis.application;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.services.ClientFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wemstar on 06.09.14.
 */
@RestController
@RequestMapping("/client/file")
public class ClientFileREST {


    @Autowired
    private ClientFileService clientFileService;

    @RequestMapping(value = "{clientNo}",method = RequestMethod.GET)
    public ClientFile getClientFile(@PathVariable long clientNo)
    {
        return clientFileService.getByClientNo(clientNo);
    }


}
