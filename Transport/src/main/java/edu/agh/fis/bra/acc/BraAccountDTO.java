package edu.agh.fis.bra.acc;

import java.util.Set;

/**
 * Created by wemstar on 29.09.14.
 */
public class BraAccountDTO {

    private long braAccNo;
    private Double avalibleCash;
    private Double blockCash;
    private Set<InstrumentInfoDTO> instruments;

    @Override
    public String toString() {
        return "BraAccountDTO{" +
                "avalibleCash=" + avalibleCash +
                ", braAccNo=" + braAccNo +
                ", blockCash=" + blockCash +
                ", instruments=" + instruments +
                '}';
    }

    public Double getAvalibleCash() {
        return avalibleCash;
    }

    public void setAvalibleCash(Double avalibleCash) {
        this.avalibleCash = avalibleCash;
    }

    public Double getBlockCash() {
        return blockCash;
    }

    public void setBlockCash(Double blockCash) {
        this.blockCash = blockCash;
    }

    public long getBraAccNo() {
        return braAccNo;
    }

    public void setBraAccNo(long braAccNo) {
        this.braAccNo = braAccNo;
    }

    public Set<InstrumentInfoDTO> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<InstrumentInfoDTO> instruments) {
        this.instruments = instruments;
    }


}
