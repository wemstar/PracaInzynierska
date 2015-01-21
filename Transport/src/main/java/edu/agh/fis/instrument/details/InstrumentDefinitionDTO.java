package edu.agh.fis.instrument.details;

/**
 * DTO definicji instrumentu
 */
public class InstrumentDefinitionDTO {

    private String isin;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }
}
