package client.instrument.order.service.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO dla rynku
 */
public class MarketDTO implements Serializable {
    private String code;
    private String name;
    private Boolean active;
    private List<InstrumentDTO> instruments;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

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
                ", type='" + active + '\'' +
                '}';
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
