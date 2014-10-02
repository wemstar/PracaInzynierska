package edu.agh.fis.interfaces.rest.bra.acc;

import edu.agh.fis.bra.acc.BraAccountTransport;

/**
 * Created by wemstar on 25.09.14.
 */
public interface BraAccountREST {



    public BraAccountTransport getBraAccount(long braNo);
    public BraAccountTransport createBraAccount(BraAccountTransport braAccountTransport);
    public void updateBraAccount(BraAccountTransport braAccountTransport);
    public void deleteBraAccount(long braNo);
}
