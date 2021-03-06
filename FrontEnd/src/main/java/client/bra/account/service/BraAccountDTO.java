package client.bra.account.service;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Transportówka dla rachunku
 */
public class BraAccountDTO implements Serializable {

    private String braAccNo = "";
    private Double avalibleCash = 0.0;
    private Double blockCash = 0.0;
    private List<InstrumentInfoDTO> instruments = new ArrayList<InstrumentInfoDTO>();

    @Override
    public String toString() {
        return "BraAccountDTO{" +
                "avalibleCash=" + avalibleCash +
                ", braAccNo='" + braAccNo + '\'' +
                ", blockCash=" + blockCash +
                ", instruments=" + instruments +
                '}';
    }

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

    @JsonIgnore
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

    @JsonIgnore
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
