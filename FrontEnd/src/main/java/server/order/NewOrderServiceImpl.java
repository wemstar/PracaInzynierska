package server.order;

import client.instrument.order.service.NewOrderService;
import client.instrument.order.service.dto.MarketDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import server.file.search.ClientFileServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
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

        logger.log(Level.WARNING, "Wysłanoe zlecenie " + newOrder);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NewOrderDTO> entity = new HttpEntity<NewOrderDTO>(newOrder, headers);
        restTemplate.postForObject(ClientFileServiceImpl.server + "/order/new", entity, NewOrderDTO.class);
    }

    @Override
    public List<NewOrderDTO> getOrdersForClient(String clientNo) {
        return Arrays.asList(restTemplate.getForObject(ClientFileServiceImpl.server + "/order/client/" + clientNo, NewOrderDTO[].class));
    }
}
