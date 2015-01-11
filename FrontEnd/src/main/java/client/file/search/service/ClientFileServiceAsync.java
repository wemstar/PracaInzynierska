package client.file.search.service;

import client.bra.account.service.BraAccountDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by wemstar on 09.11.14.
 */
public interface ClientFileServiceAsync {
    void findClients(ClientFileDTO item, AsyncCallback<List<ClientFileDTO>> async);

    void saveClient(ClientFileDTO dto, AsyncCallback<Void> async);

    void createClient(ClientFileDTO dto, AsyncCallback<ClientFileDTO> async);

    void findClient(int clientNo, AsyncCallback<ClientFileDTO> async);

    void saveBraAccount(ClientFileDTO client, BraAccountDTO braAccount, AsyncCallback<BraAccountDTO> async);

    void deleteClientFile(ClientFileDTO flush, AsyncCallback<Void> async);

    void deleteBraAccount(String braAccNo, AsyncCallback<Void> asyncCallback);

    void validateUser(UserDTO user, AsyncCallback<Boolean> asyncCallback);
}
