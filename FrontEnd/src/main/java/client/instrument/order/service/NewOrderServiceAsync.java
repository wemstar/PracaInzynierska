package client.instrument.order.service;

import client.instrument.order.service.dto.MarketDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface NewOrderServiceAsync {


    void createNewOrder(NewOrderDTO newOrder, AsyncCallback<Void> async);

    void getMarkets(AsyncCallback<List<MarketDTO>> async);
}
