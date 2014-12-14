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
public interface ClientFileService extends RemoteService {
    public List<ClientFileDTO> findClients(ClientFileDTO item);

    public void saveClient(ClientFileDTO dto);

    BraAccountDTO saveBraAccount(ClientFileDTO client, BraAccountDTO braAccount);

    ClientFileDTO createClient(ClientFileDTO dto);

    ClientFileDTO findClient(int clientNo);

    void deleteClientFile(ClientFileDTO flush);

    /**
     * Utility/Convenience class.
     * Use ClientSearchService.App.getInstance() to access static instance of ClientSearchServiceAsync
     */
    public static class App {
        private static final ClientFileServiceAsync ourInstance = (ClientFileServiceAsync) GWT.create(ClientFileService.class);

        public static ClientFileServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
