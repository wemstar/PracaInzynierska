package client.file.search.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by wemstar on 09.11.14.
 */
public interface ClientSearchServiceAsync {
    void findClients(SearchClientDTO item, AsyncCallback<List<SearchClientDTO>> async);
}
