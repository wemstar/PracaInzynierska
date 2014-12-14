package client.instrument.order.service;

import client.instrument.order.service.dto.InstrumentDTO;
import client.instrument.order.service.dto.NewOrderDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface NewOrderServiceAsync {

    void getInstruments(AsyncCallback<List<InstrumentDTO>> async);

    void createNewOrder(NewOrderDTO newOrder, AsyncCallback<Void> async);
}
