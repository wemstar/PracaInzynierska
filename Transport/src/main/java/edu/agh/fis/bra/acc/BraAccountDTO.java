package edu.agh.fis.bra.acc;

import java.util.Set;

/**
 * Created by wemstar on 29.09.14.
 */
public class BraAccountDTO {

    private long braAccNo;
    private double balance;
    private Set<InstrumentInfoDTO> instruments;

    @Override
    public String toString() {
        return "BraAccountDTO{" +
                "balance=" + balance +
                ", braAccNo=" + braAccNo +
                ", instruments=" + instruments +
                '}';
    }

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


}
