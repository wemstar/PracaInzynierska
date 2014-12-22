package client.instrument.service;

import client.bra.account.service.BraAccountDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface InstrumentServiceAsync {


    void getInstrumentForBraAccount(BraAccountDTO braContext, AsyncCallback<List<InstrumentListDetails>> async);
}
