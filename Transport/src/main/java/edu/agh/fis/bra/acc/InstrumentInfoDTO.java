package edu.agh.fis.bra.acc;

import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

/**
 * Created by wemstar on 11.10.14.
 */
public class InstrumentInfoDTO {

    private InstrumentDefinitionDTO definition;

    private long quantity;

    @Override
    public String toString() {
        return "InstrumentInfoDTO{" +
                "definition=" + definition +
                ", quantity=" + quantity +
                '}';
    }

    public InstrumentDefinitionDTO getDefinition() {
        return definition;
    }

    public void setDefinition(InstrumentDefinitionDTO definition) {
        this.definition = definition;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
