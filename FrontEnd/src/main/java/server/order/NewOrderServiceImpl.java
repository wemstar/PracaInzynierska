package server.order;

import client.instrument.order.service.NewOrderService;
import client.instrument.order.service.dto.InstrumentDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import server.DoomyData;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wemstar on 30.11.14.
 */
public class NewOrderServiceImpl extends RemoteServiceServlet implements NewOrderService {

    public final Logger logger = Logger.getLogger("NameOfYourLogger");

    @Override
    public List<InstrumentDTO> getInstruments() {
        return DoomyData.instrumentsList;
    }

    @Override
    public void createNewOrder(NewOrderDTO newOrder) {
        logger.log(Level.WARNING, "Złożono zlecenie " + newOrder);
    }
}
