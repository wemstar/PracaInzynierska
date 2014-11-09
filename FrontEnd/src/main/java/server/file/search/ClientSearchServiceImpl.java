package server.file.search;

import client.file.search.service.ClientSearchService;
import client.file.search.service.SearchClientDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wemstar on 09.11.14.
 */
public class ClientSearchServiceImpl extends RemoteServiceServlet implements ClientSearchService {
    @Override
    public List<SearchClientDTO> findClients(SearchClientDTO item) {


        SearchClientDTO pro1 = new SearchClientDTO();
        pro1.setClientNo("1");
        pro1.setName("Hura1");
        pro1.setSurname("Hura1");
        SearchClientDTO pro2 = new SearchClientDTO();
        pro2.setClientNo("2");
        pro2.setName("Hura2");
        pro2.setSurname("Hura2");
        SearchClientDTO pro3 = new SearchClientDTO();
        pro3.setClientNo("3");
        pro3.setName("Hura3");
        pro3.setSurname("Hura3");

        return Arrays.asList(new SearchClientDTO[]{pro1, pro2, pro3});
    }
}