package server.file.search;

import client.bra.account.service.BraAccountDTO;
import client.file.search.service.ClientSearchService;
import client.file.search.service.SearchClientDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by wemstar on 09.11.14.
 */
public class ClientFileServiceImpl extends RemoteServiceServlet implements ClientSearchService {


    private static final String server = "http://fixapplicationbackend.appspot.com";
    private static final String local = "http://localhost:8085";

    public final Logger logger = Logger.getLogger("ClientFileLogger");
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<SearchClientDTO> findClients(SearchClientDTO item) {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        SearchClientDTO[] table = restTemplate.postForObject(server + "/client/file/template", item, SearchClientDTO[].class);
        return Arrays.asList(table);
    }

    @Override
    public void saveClient(SearchClientDTO dto) {
        logger.log(Level.WARNING, "Zapisano kartotekę " + dto.toString());
        restTemplate.put(server + "/client/file", dto, SearchClientDTO.class);
    }

    @Override
    public SearchClientDTO createClient(SearchClientDTO dto) {
        logger.log(Level.WARNING, "Utworzono kartotękę " + dto.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SearchClientDTO> entity = new HttpEntity<SearchClientDTO>(dto, headers);
        return restTemplate.postForObject(server + "/client/file", entity, SearchClientDTO.class);
    }

    @Override
    public BraAccountDTO saveBraAccount(SearchClientDTO client, BraAccountDTO braAccount) {
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
    public SearchClientDTO findClient(int clientNo) {

        return restTemplate.getForObject(server + "/client/file/" + clientNo, SearchClientDTO.class);
    }

    @Override
    public void deleteClientFile(SearchClientDTO flush) {

    }


}