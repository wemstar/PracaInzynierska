package client.file.search.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Created by wemstar on 09.11.14.
 */
@RemoteServiceRelativePath("ClientSearchService")
public interface ClientSearchService extends RemoteService {
    public List<SearchClientDTO> findClients(SearchClientDTO item);

    /**
     * Utility/Convenience class.
     * Use ClientSearchService.App.getInstance() to access static instance of ClientSearchServiceAsync
     */
    public static class App {
        private static final ClientSearchServiceAsync ourInstance = (ClientSearchServiceAsync) GWT.create(ClientSearchService.class);

        public static ClientSearchServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
