package server.file.search;

import client.file.search.service.SearchClientDTO;

import java.util.*;

/**
 * Created by wemstar on 18.11.14.
 */
public class DoomyData {



    public static List<SearchClientDTO> listOfClients;
    static
    {
        SearchClientDTO pro1 = new SearchClientDTO();
        pro1.setClientNo("5");
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
        listOfClients=new ArrayList<SearchClientDTO>();
        listOfClients.add(pro1);
        listOfClients.add(pro2);
        listOfClients.add(pro3);
    }
}
