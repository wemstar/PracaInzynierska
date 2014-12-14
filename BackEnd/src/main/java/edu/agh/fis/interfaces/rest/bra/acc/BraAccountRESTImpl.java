package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.core.bra.acc.services.BraAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wemstar on 25.09.14.
 */
@RestController
@RequestMapping("/bra/acc")

public class BraAccountRESTImpl implements BraAccountREST {

    @Autowired
    private BraAccountTransformer braAccountTransformer;

    @Autowired
    private BraAccountServices braAccountServices;

    @Override
    @RequestMapping(value = "/{braNo}", method = RequestMethod.GET)
    public BraAccountDTO getBraAccount(@PathVariable long braNo) {
        return braAccountTransformer.entityToTransport(braAccountServices.getBraAcc(braNo));

    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public BraAccountDTO createBraAccount(@RequestBody BraAccountDTO braAccountDTO) {
        return braAccountTransformer.entityToTransport(braAccountServices.createBraAcc(braAccountTransformer.transportToEntity(braAccountDTO)));
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBraAccount(@RequestBody BraAccountDTO braAccountDTO) {

        braAccountServices.updateBraAcc(braAccountTransformer.transportToEntity(braAccountDTO));

    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{braNo}", method = RequestMethod.DELETE)
    public void deleteBraAccount(@PathVariable long braNo) {

        braAccountServices.deleteBraAcc(braNo);

    }

    @Override
    @RequestMapping(value = "{clientNo}", method = RequestMethod.POST)
    public BraAccountDTO addAccountToCLient(@PathVariable long clientNo, @RequestBody BraAccountDTO braAccount) {
        return braAccountTransformer.entityToTransport(braAccountServices.addAccountToClient(clientNo, braAccountTransformer.transportToEntity(braAccount)));
    }
}
