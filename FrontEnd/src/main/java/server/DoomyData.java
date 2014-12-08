package server;

import client.bra.account.service.BraAccountDTO;
import client.file.search.service.SearchClientDTO;
import client.instrument.order.service.dto.InstrumentDTO;
import client.instrument.order.service.dto.MarketDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wemstar on 18.11.14.
 */
public class DoomyData {



    public static List<SearchClientDTO> listOfClients;
    public static List<InstrumentDTO> instrumentsList;
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


        instrumentsList = new ArrayList<InstrumentDTO>();
        InstrumentDTO instrument = new InstrumentDTO();
        MarketDTO market = new MarketDTO();
        market.setName("Wall street");
        market.setCode("NASDAQ");
        market.setType("Instruments");
        MarketDTO market2 = new MarketDTO();
        market.setName("Giełda papierów wartościowych");
        market.setCode("GPW");
        market.setType("Instruments");
        instrument.setName("KGHM");
        instrument.setCount(20);
        instrument.setIsin("PLKGHM");
        instrument.setMarket(Arrays.asList(new MarketDTO[]{market, market2}));
        instrumentsList.add(instrument);
        instrument = new InstrumentDTO();
        instrument.setName("JSW");
        instrument.setCount(10);
        instrument.setIsin("PLJSW");
        instrument.setMarket(Arrays.asList(new MarketDTO[]{market}));
        instrumentsList.add(instrument);

    }


    public static BraAccountDTO getData1() {

        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("1");
        dto.setAvalibleCash(20.0);

        return dto;
    }

    public static BraAccountDTO getData2() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("2");
        dto.setAvalibleCash(30.0);

        return dto;
    }

    public static BraAccountDTO getData3() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("3");
        dto.setAvalibleCash(40.0);

        return dto;
    }
}
