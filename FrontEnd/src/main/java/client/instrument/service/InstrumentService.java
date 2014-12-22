package client.instrument.service;

import client.bra.account.service.BraAccountDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
@RemoteServiceRelativePath("InstrumentService")
public interface InstrumentService extends RemoteService {

    List<InstrumentListDetails> getInstrumentForBraAccount(BraAccountDTO braContext);

    public static class App {
        private static final InstrumentServiceAsync ourInstance = (InstrumentServiceAsync) GWT.create(InstrumentService.class);

        public static InstrumentServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
