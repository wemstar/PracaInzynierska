package edu.agh.fis.builder.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;

import java.util.Set;

/**
 * Created by wemstar on 11.10.14.
 */
public class BraAccountDTOBuilder {
    private long braAccNo;
    private double balance;
    private Set<InstrumentInfoDTO> instruments;

    private BraAccountDTOBuilder() {
    }

    public static BraAccountDTOBuilder aBraAccountTransport() {
        return new BraAccountDTOBuilder();
    }

    public BraAccountDTOBuilder braAccNo(long braAccNo) {
        this.braAccNo = braAccNo;
        return this;
    }

    public BraAccountDTOBuilder balance(double balance) {
        this.balance = balance;
        return this;
    }

    public BraAccountDTOBuilder instruments(Set<InstrumentInfoDTO> instruments) {
        this.instruments = instruments;
        return this;
    }

    public BraAccountDTOBuilder but() {
        return aBraAccountTransport().braAccNo(braAccNo).balance(balance).instruments(instruments);
    }

    public BraAccountDTO build() {
        BraAccountDTO braAccountDTO = new BraAccountDTO();
        braAccountDTO.setBraAccNo(braAccNo);
        braAccountDTO.setBalance(balance);
        braAccountDTO.setInstruments(instruments);
        return braAccountDTO;
    }
}
