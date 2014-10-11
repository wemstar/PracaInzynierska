package edu.agh.fis.bra.acc;

import java.util.Set;

/**
 * Created by wemstar on 29.09.14.
 */
public class BraAccountDTO {

    public long getBraAccNo() {
        return braAccNo;
    }

    public void setBraAccNo(long braAccNo) {
        this.braAccNo = braAccNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Set<InstrumentInfoDTO> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<InstrumentInfoDTO> instruments) {
        this.instruments = instruments;
    }

    public long braAccNo;

    public double balance;

    public Set<InstrumentInfoDTO> instruments;


}
