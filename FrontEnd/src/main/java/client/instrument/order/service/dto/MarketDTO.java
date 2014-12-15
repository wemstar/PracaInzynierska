package client.instrument.order.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wemstar on 30.11.14.
 */
public class MarketDTO implements Serializable {
    private String code;
    private String name;
    private String type;
    private List<InstrumentDTO> instruments;

    public List<InstrumentDTO> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<InstrumentDTO> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "MerketsDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
