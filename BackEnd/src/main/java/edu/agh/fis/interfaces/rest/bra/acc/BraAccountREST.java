package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;

/**
 * Created by wemstar on 25.09.14.
 */
public interface BraAccountREST {


    public BraAccountDTO getBraAccount(long braNo);

    public BraAccountDTO createBraAccount(BraAccountDTO braAccountDTO);

    public void updateBraAccount(BraAccountDTO braAccountDTO);

    public void deleteBraAccount(long braNo);
}
