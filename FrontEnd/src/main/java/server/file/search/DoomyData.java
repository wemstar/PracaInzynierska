package server.file.search;

import client.bra.account.service.BraAccountDTO;
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
        pro1.setPesel("92148536998");
        pro1.setBraAccount(Arrays.asList(new BraAccountDTO[]{getData1(),getData2(),getData3()}));
        SearchClientDTO pro2 = new SearchClientDTO();
        pro2.setClientNo("2");
        pro2.setName("Hura2");
        pro2.setSurname("Hura2");
        pro2.setPesel("92148536998");
        pro2.setBraAccount(Arrays.asList(new BraAccountDTO[]{getData1(),getData2(),getData3()}));
        SearchClientDTO pro3 = new SearchClientDTO();
        pro3.setClientNo("3");
        pro3.setName("Hura3");
        pro3.setSurname("Hura3");
        pro3.setPesel("92148536998");
        pro3.setBraAccount(Arrays.asList(new BraAccountDTO[]{getData1(),getData2(),getData3()}));
        listOfClients=new ArrayList<SearchClientDTO>();
        listOfClients.add(pro1);
        listOfClients.add(pro2);
        listOfClients.add(pro3);
    }


    public static BraAccountDTO getData1() {

        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("1");
        dto.setBalance(10.0);

        return dto;
    }

    public static BraAccountDTO getData2() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("2");
        dto.setBalance(20.0);

        return dto;
    }

    public static BraAccountDTO getData3() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("3");
        dto.setBalance(30.0);

        return dto;
    }
}
