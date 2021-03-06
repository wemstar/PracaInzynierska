package client.instrument.order.service;

import client.instrument.order.service.dto.MarketDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Serwis do składania nowego zlecenia
 */
@RemoteServiceRelativePath("NewOrderService")
public interface NewOrderService extends RemoteService {
    public List<MarketDTO> getMarkets();

    void createNewOrder(NewOrderDTO newOrder);

    List<NewOrderDTO> getOrdersForClient(String clientNo);

    public static class App {
        private static final NewOrderServiceAsync ourInstance = (NewOrderServiceAsync) GWT.create(NewOrderService.class);

        public static NewOrderServiceAsync getInstance() {
            return ourInstance;
        }
    }

}
