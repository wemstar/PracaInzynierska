package server.order;

import client.instrument.order.service.NewOrderService;
import client.instrument.order.service.dto.MarketDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.web.client.RestTemplate;
import server.file.search.ClientFileServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by wemstar on 30.11.14.
 */
public class NewOrderServiceImpl extends RemoteServiceServlet implements NewOrderService {

    public final Logger logger = Logger.getLogger("NameOfYourLogger");

    RestTemplate restTemplate = new RestTemplate();
    @Override
    public List<MarketDTO> getMarkets() {

        return Arrays.asList(restTemplate.getForObject(ClientFileServiceImpl.server + "/market/all/active", MarketDTO[].class));
    }

    @Override
    public void createNewOrder(NewOrderDTO newOrder) {

        restTemplate.put(ClientFileServiceImpl.server + "/order/new", newOrder, NewOrderDTO.class);
    }
}
