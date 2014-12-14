package client.file.search.service;

import client.bra.account.service.BraAccountDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by wemstar on 09.11.14.
 */
public interface ClientSearchServiceAsync {
    void findClients(SearchClientDTO item, AsyncCallback<List<SearchClientDTO>> async);


    void saveClient(SearchClientDTO dto, AsyncCallback<Void> async);


    void createClient(SearchClientDTO dto, AsyncCallback<SearchClientDTO> async);


    void findClient(int clientNo, AsyncCallback<SearchClientDTO> async);


    void saveBraAccount(SearchClientDTO client, BraAccountDTO braAccount, AsyncCallback<BraAccountDTO> async);


    void deleteClientFile(SearchClientDTO flush, AsyncCallback<Void> async);
}
