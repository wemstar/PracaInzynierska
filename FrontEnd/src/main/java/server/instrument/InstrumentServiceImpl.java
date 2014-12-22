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


        return Arrays.asList(restTemple.getForObject(ClientFileServiceImpl.server + "/bra/acc/instrument/list/" + braContext.getBraAccNo(), InstrumentListDetails[].class));
    }

     /*Date startDate=new Date();


        InstrumentHistory history1=new InstrumentHistory();
        history1.setDate(startDate);
        history1.setOpenPrice(20.0);
        history1.setClosePrice(10.0);
        history1.setMaxPrice(40.0);
        history1.setMinPrice(5.0);

new ArrayList<InstrumentListDetails>();//
        startDate=new Date();
        CalendarUtil.addDaysToDate(startDate, 1);
        InstrumentHistory history2=new InstrumentHistory();
        history2.setDate(startDate);
        history2.setOpenPrice(20.0);
        history2.setClosePrice(10.0);
        history2.setMaxPrice(40.0);
        history2.setMinPrice(5.0);


        startDate=new Date();
        CalendarUtil.addDaysToDate(startDate, 2);
        InstrumentHistory history3=new InstrumentHistory();
        history3.setDate(startDate);
        history3.setOpenPrice(20.0);
        history3.setClosePrice(10.0);
        history3.setMaxPrice(40.0);
        history3.setMinPrice(5.0);


        startDate=new Date();
        CalendarUtil.addDaysToDate(startDate, 3);
        InstrumentHistory history4=new InstrumentHistory();
        history4.setDate(startDate);
        history4.setOpenPrice(20.0);
        history4.setClosePrice(10.0);
        history4.setMaxPrice(40.0);
        history4.setMinPrice(5.0);


        startDate=new Date();
        CalendarUtil.addDaysToDate(startDate, 4);
        InstrumentHistory history5=new InstrumentHistory();
        history5.setDate(startDate);
        history5.setOpenPrice(20.0);
        history5.setClosePrice(10.0);
        history5.setMaxPrice(40.0);
        history5.setMinPrice(5.0);


        startDate=new Date();
        CalendarUtil.addDaysToDate(startDate, 5);
        InstrumentHistory history6=new InstrumentHistory();
        history6.setDate(startDate);
        history6.setOpenPrice(20.0);
        history6.setClosePrice(10.0);
        history6.setMaxPrice(40.0);
        history6.setMinPrice(5.0);


        startDate=new Date();
        CalendarUtil.addDaysToDate(startDate, 6);
        InstrumentHistory history7=new InstrumentHistory();
        history7.setDate(startDate);
        history7.setOpenPrice(20.0);
        history7.setClosePrice(10.0);
        history7.setMaxPrice(40.0);
        history7.setMinPrice(5.0);



        return Arrays.asList(new InstrumentHistory[]{history1,history2,history3,history4,history5,history6,history7});*/
}
