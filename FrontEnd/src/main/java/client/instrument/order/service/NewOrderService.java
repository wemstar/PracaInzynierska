package client.instrument.order.service;

import client.instrument.order.service.dto.MarketDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Created by wemstar on 30.11.14.
 */
@RemoteServiceRelativePath("NewOrderService")
public interface NewOrderService extends RemoteService {
    public List<MarketDTO> getMarkets();

    void createNewOrder(NewOrderDTO newOrder);

    public static class App {
        private static final NewOrderServiceAsync ourInstance = (NewOrderServiceAsync) GWT.create(NewOrderService.class);

        public static NewOrderServiceAsync getInstance() {
            return ourInstance;
        }
    }

}
