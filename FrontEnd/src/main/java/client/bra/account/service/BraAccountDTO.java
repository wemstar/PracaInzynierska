package client.bra.account.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wemstar on 11.11.14.
 */
public class BraAccountDTO implements Serializable {

    private String braAccNo;
    private Double avalibleCash;
    private Double blockCash;
    private List<InstrumentInfoDTO> instruments;

    public List<InstrumentInfoDTO> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<InstrumentInfoDTO> instruments) {
        this.instruments = instruments;
    }

    public Double getBlockCash() {
        return blockCash;
    }


    public void setBlockCash(Double blockCash) {
        this.blockCash = blockCash;
    }

    public String getBlockCashStr() {
        return blockCash.toString();
    }

    public void setBlockCashStr(String value) {
        blockCash = Double.parseDouble(value);
    }

    public Double getAvalibleCash() {
        return avalibleCash;
    }

    public void setAvalibleCash(Double avalibleCash) {
        this.avalibleCash = avalibleCash;
    }

    public String getAvalibleCashStr() {
        return avalibleCash.toString();
    }

    public void setAvalibleCashStr(String value) {
        avalibleCash = Double.parseDouble(value);
    }




    public String getBraAccNo() {
        return braAccNo;
    }

    public void setBraAccNo(String braAccNo) {
        this.braAccNo = braAccNo;
    }
}
