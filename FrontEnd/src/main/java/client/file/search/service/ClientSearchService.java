package client.file.search.service;

import client.bra.account.service.BraAccountDTO;
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

    public void saveClient(SearchClientDTO dto);

    BraAccountDTO saveBraAccount(SearchClientDTO client, BraAccountDTO braAccount);

    SearchClientDTO createClient(SearchClientDTO dto);

    SearchClientDTO findClient(int clientNo);

    void deleteClientFile(SearchClientDTO flush);


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
