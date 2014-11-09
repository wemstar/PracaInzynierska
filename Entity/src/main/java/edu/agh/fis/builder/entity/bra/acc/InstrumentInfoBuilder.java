package edu.agh.fis.builder.entity.bra.acc;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

/**
 * Created by wemstar on 11.10.14.
 */
public class InstrumentInfoBuilder {
    private long id;
    private InstrumentDefinition instrumentDefinition;
    private long quantity;
    private BraAccount braAccount;

    private InstrumentInfoBuilder() {
    }

    public static InstrumentInfoBuilder anInstrumentInfo() {
        return new InstrumentInfoBuilder();
    }

    InstrumentInfoBuilder id(long id) {
        this.id = id;
        return this;
    }

    public InstrumentInfoBuilder instrumentDefinition(InstrumentDefinition instrumentDefinition) {
        this.instrumentDefinition = instrumentDefinition;
        return this;
    }

    public InstrumentInfoBuilder quantity(long quantity) {
        this.quantity = quantity;
        return this;
    }

    public InstrumentInfoBuilder braAccount(BraAccount braAccount) {
        this.braAccount = braAccount;
        return this;
    }

    public InstrumentInfoBuilder but() {
        return anInstrumentInfo().id(id).instrumentDefinition(instrumentDefinition).quantity(quantity).braAccount(braAccount);
    }

    public InstrumentInfo build() {
        InstrumentInfo instrumentInfo = new InstrumentInfo();
        instrumentInfo.setId(id);
        instrumentInfo.setInstrumentDefinition(instrumentDefinition);
        instrumentInfo.setQuantity(quantity);
        instrumentInfo.setBraAccount(braAccount);
        return instrumentInfo;
    }
}
