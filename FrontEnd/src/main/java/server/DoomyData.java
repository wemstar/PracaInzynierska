package server;

import client.bra.account.service.BraAccountDTO;
import client.bra.account.service.InstrumentInfoDTO;
import client.file.search.service.ClientFileDTO;
import client.instrument.order.service.dto.InstrumentDTO;
import client.instrument.order.service.dto.MarketDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by wemstar on 18.11.14.
 */
public class DoomyData {


    public static List<ClientFileDTO> listOfClients;
    public static List<InstrumentDTO> instrumentsList;
    static
    {
        ClientFileDTO pro1 = new ClientFileDTO();
        pro1.setClientNo("5");
        pro1.setName("Hura1");
        pro1.setSurname("Hura1");
        pro1.setPesel("92148536998");
        pro1.setAccounts(Arrays.asList(new BraAccountDTO[]{getData1(), getData2(), getData3()}));
        pro1.setDateOfBirth(new Date());
        ClientFileDTO pro2 = new ClientFileDTO();
        pro2.setClientNo("2");
        pro2.setName("Hura2");
        pro2.setSurname("Hura2");
        pro2.setPesel("92148536998");
        pro2.setAccounts(Arrays.asList(new BraAccountDTO[]{getData1(), getData2(), getData3()}));
        pro2.setDateOfBirth(new Date());
        ClientFileDTO pro3 = new ClientFileDTO();
        pro3.setClientNo("3");
        pro3.setName("Hura3");
        pro3.setSurname("Hura3");
        pro3.setPesel("92148536998");
        pro3.setAccounts(Arrays.asList(new BraAccountDTO[]{getData1(), getData2(), getData3()}));
        pro3.setDateOfBirth(new Date());
        listOfClients = new ArrayList<ClientFileDTO>();
        listOfClients.add(pro1);
        listOfClients.add(pro2);
        listOfClients.add(pro3);


        instrumentsList = getInstrumentsList();

    }

    public static List<InstrumentDTO> getInstrumentsList() {
        List<InstrumentDTO> instruments = new ArrayList<InstrumentDTO>();
        InstrumentDTO instrument = new InstrumentDTO();
        MarketDTO market = new MarketDTO();
        market.setName("Wall street");
        market.setCode("NASDAQ");

        MarketDTO market2 = new MarketDTO();
        market.setName("Giełda papierów wartościowych");
        market.setCode("GPW");

        instrument.setName("KGHM");
        instrument.setIsin("PLKGHM");

        instruments.add(instrument);
        instrument = new InstrumentDTO();
        instrument.setName("JSW");

        instrument.setIsin("PLJSW");

        instruments.add(instrument);
        return instruments;
    }


    public static BraAccountDTO getData1() {

        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("1");
        dto.setAvalibleCash(20.0);
        dto.setBlockCash(10.0);
        List<InstrumentDTO> instruments = getInstrumentsList();
        List<InstrumentInfoDTO> intrumentInfo = new ArrayList<InstrumentInfoDTO>();
        for (InstrumentDTO instrument : instruments) {
            InstrumentInfoDTO info = new InstrumentInfoDTO();
            info.setAmmount(20L);
            info.setBlocked(5L);
            info.setInstrument(instrument);
            intrumentInfo.add(info);
        }
        dto.setInstruments(intrumentInfo);
        return dto;
    }

    public static BraAccountDTO getData2() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("2");
        dto.setAvalibleCash(30.0);
        dto.setBlockCash(10.0);
        List<InstrumentDTO> instruments = getInstrumentsList();
        List<InstrumentInfoDTO> intrumentInfo = new ArrayList<InstrumentInfoDTO>();
        for (InstrumentDTO instrument : instruments) {
            InstrumentInfoDTO info = new InstrumentInfoDTO();
            info.setAmmount(20L);
            info.setBlocked(5L);
            ;
            info.setInstrument(instrument);
            intrumentInfo.add(info);
        }
        dto.setInstruments(intrumentInfo);

        return dto;
    }

    public static BraAccountDTO getData3() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("3");
        dto.setAvalibleCash(40.0);
        dto.setBlockCash(10.0);
        List<InstrumentDTO> instruments = getInstrumentsList();
        List<InstrumentInfoDTO> intrumentInfo = new ArrayList<InstrumentInfoDTO>();
        for (InstrumentDTO instrument : instruments) {
            InstrumentInfoDTO info = new InstrumentInfoDTO();
            info.setAmmount(20L);
            info.setBlocked(5L);
            info.setInstrument(instrument);
            intrumentInfo.add(info);
        }
        dto.setInstruments(intrumentInfo);

        return dto;
    }
}
