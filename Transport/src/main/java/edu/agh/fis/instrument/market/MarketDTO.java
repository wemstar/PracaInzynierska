package edu.agh.fis.instrument.market;

import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
public class MarketDTO {


    private String name;
    private Boolean active;
    private List<InstrumentDefinitionDTO> instruments;
    private String code;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<InstrumentDefinitionDTO> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<InstrumentDefinitionDTO> instruments) {
        this.instruments = instruments;
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

    @Override
    public String
    toString() {
        return "MarketDTO{" +
                "active=" + active +
                ", name='" + name + '\'' +
                ", instruments=" + instruments +
                ", code='" + code + '\'' +
                '}';
    }
}
