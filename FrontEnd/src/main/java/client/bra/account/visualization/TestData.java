package client.bra.account.visualization;

import client.bra.account.service.BraAccountDTO;

/**
 * Created by wemstar on 11.11.14.
 */
public class TestData {


    public static BraAccountDTO getData1() {

        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("1");
        dto.setBalance(25.0);

        return dto;
    }

    public static BraAccountDTO getData2() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("2");
        dto.setBalance(25.0);

        return dto;
    }

    public static BraAccountDTO getData3() {


        BraAccountDTO dto = new BraAccountDTO();
        dto.setBraAccNo("3");
        dto.setBalance(25.0);

        return dto;
    }
}
