package server.file.search;

import client.file.search.service.ClientSearchService;
import client.file.search.service.SearchClientDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import server.DoomyData;

import java.util.List;

/**
 * Created by wemstar on 09.11.14.
 */
public class ClientSearchServiceImpl extends RemoteServiceServlet implements ClientSearchService {
    @Override
    public List<SearchClientDTO> findClients(SearchClientDTO item) {



        /*RestTemplate restTemplate=new RestTemplate();
        SearchClientDTO dto4=restTemplate.getForObject("http://fixapplicationbackend.appspot.com//client/file/1",SearchClientDTO.class);*/
        return DoomyData.listOfClients;
    }
}