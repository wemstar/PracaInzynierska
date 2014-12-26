package server.instrument;

import client.bra.account.service.BraAccountDTO;
import client.instrument.service.InstrumentListDetails;
import client.instrument.service.InstrumentService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.web.client.RestTemplate;
import server.file.search.ClientFileServiceImpl;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wemstar on 21.12.14.
 */
public class InstrumentServiceImpl extends RemoteServiceServlet implements InstrumentService {


        private RestTemplate restTemple = new RestTemplate();

        @Override
        public List<InstrumentListDetails> getInstrumentForBraAccount(BraAccountDTO braContext) {


                return Arrays.asList(restTemple.getForObject(ClientFileServiceImpl.server + "/instrument/list/bra/account/" + braContext.getBraAccNo(), InstrumentListDetails[].class));
        }

        @Override
        public List<InstrumentListDetails> getAllIntrumentOnTrade() {
                return Arrays.asList(restTemple.getForObject(ClientFileServiceImpl.server + "/instrument/list/all", InstrumentListDetails[].class));
        }

}
