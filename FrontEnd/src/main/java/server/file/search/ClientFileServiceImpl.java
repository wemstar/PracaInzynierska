package server.file.search;

import client.bra.account.service.BraAccountDTO;
import client.file.search.service.ClientFileDTO;
import client.file.search.service.ClientFileService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wemstar on 09.11.14.
 */
public class ClientFileServiceImpl extends RemoteServiceServlet implements ClientFileService {

    public static final String server = "http://fixapplicationbackend.appspot.com";
    private static final String local = "http://localhost:8085";

    public final Logger logger = Logger.getLogger("ClientFileLogger");
    RestTemplate restTemplate = new RestTemplate();

    public ClientFileServiceImpl() {
        SimpleClientHttpRequestFactory rf =
                (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
        rf.setReadTimeout(10 * 1000);
        rf.setConnectTimeout(10 * 1000);


    }

    @Override
    public List<ClientFileDTO> findClients(ClientFileDTO item) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ClientFileDTO[] table = restTemplate.postForObject(server + "/client/file/template", item, ClientFileDTO[].class);
        return Arrays.asList(table);
    }

    @Override
    public void saveClient(ClientFileDTO dto) {
        logger.log(Level.WARNING, "Zapisano kartotekę " + dto.toString());
        restTemplate.put(server + "/client/file", dto, ClientFileDTO.class);
    }

    @Override
    public ClientFileDTO createClient(ClientFileDTO dto) {
        logger.log(Level.WARNING, "Utworzono kartotękę " + dto.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ClientFileDTO> entity = new HttpEntity<ClientFileDTO>(dto, headers);
        return restTemplate.postForObject(server + "/client/file", entity, ClientFileDTO.class);
    }

    @Override
    public BraAccountDTO saveBraAccount(ClientFileDTO client, BraAccountDTO braAccount) {
        logger.log(Level.WARNING, "Zapisano rachunek " + braAccount.toString());
        BraAccountDTO result = braAccount;
        if (!braAccount.getBraAccNo().isEmpty()) {
            restTemplate.put(server + "/bra/acc", braAccount);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<BraAccountDTO> entity = new HttpEntity<BraAccountDTO>(braAccount, headers);
            result = restTemplate.postForObject(server + "/bra/acc/" + client.getClientNo(), entity, BraAccountDTO.class);
        }
        return result;
    }

    @Override
    public ClientFileDTO findClient(int clientNo) {

        return restTemplate.getForObject(server + "/client/file/" + clientNo, ClientFileDTO.class);
    }

    @Override
    public void deleteClientFile(ClientFileDTO flush) {

    }


}