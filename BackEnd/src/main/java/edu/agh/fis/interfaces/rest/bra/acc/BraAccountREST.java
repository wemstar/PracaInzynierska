package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Przetwarza zapytania REST dla rachunków
 */
public interface BraAccountREST {


    public BraAccountDTO getBraAccount(long braNo);

    public BraAccountDTO createBraAccount(BraAccountDTO braAccountDTO);

    public void updateBraAccount(BraAccountDTO braAccountDTO);

    public void deleteBraAccount(long braNo);

    @RequestMapping(value = "{clientNo}", method = RequestMethod.POST)
    BraAccountDTO addAccountToCLient(@PathVariable long clientNo, @RequestBody BraAccountDTO braAccount);
}
