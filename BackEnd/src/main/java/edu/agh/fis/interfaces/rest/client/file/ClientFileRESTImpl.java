package edu.agh.fis.interfaces.rest.client.file;

import edu.agh.fis.client.file.ClientFileDTO;
import edu.agh.fis.core.client.file.services.ClientFileService;
import edu.agh.fis.utils.logger.InjectLogger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wemstar on 06.09.14.
 */

@RestController
@RequestMapping("/client/file")
public class ClientFileRESTImpl implements ClientFileREST {

    @InjectLogger
    public Logger logger;

    @Autowired
    private ClientFileService clientFileService;

    @Autowired
    private ClientFileTransformerREST transformer;

    @Override
    @RequestMapping(value = "/{clientNo}", method = RequestMethod.GET)
    public ClientFileDTO getClientFile(@PathVariable long clientNo) {
        logger.info("HURA działa");
        return transformer.entityToTransport(clientFileService.getByClientNo(clientNo));
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ClientFileDTO createClientFile(@RequestBody ClientFileDTO clientFile) {


        return transformer.entityToTransport(clientFileService.createClientFile(transformer.transportToEntity(clientFile)));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClientFile(@RequestBody ClientFileDTO transport) {

        clientFileService.updateClientFile(transformer.transportToEntity(transport));

    }

    @Override
    @RequestMapping(value = "{clientNo}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientFile(@PathVariable long clientNo) {
        clientFileService.deleteClientFile(clientNo);

    }

    @Override
    @RequestMapping(value = "/template", method = RequestMethod.POST)

    public List<ClientFileDTO> getClientsByTemplate(@RequestBody ClientFileDTO template) {
        return transformer.entityToTransportList(clientFileService.getByTemplate(transformer.transportToEntity(template)));
    }


}
