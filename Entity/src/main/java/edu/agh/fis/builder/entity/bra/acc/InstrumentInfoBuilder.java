package edu.agh.fis.builder.entity.bra.acc;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

/**
 * Builder dla Infromacji o intrumentach
 */
public class InstrumentInfoBuilder {
    private long ammount;
    private long id;
    private InstrumentDefinition instrumentDefinition;
    private long blocked;
    private BraAccount braAccount;

    private InstrumentInfoBuilder() {
    }

    public static InstrumentInfoBuilder anInstrumentInfo() {
        return new InstrumentInfoBuilder();
    }

    public InstrumentInfoBuilder ammount(long ammount) {
        this.ammount = ammount;
        return this;
    }

    public InstrumentInfoBuilder id(long id) {
        this.id = id;
        return this;
    }

    public InstrumentInfoBuilder instrumentDefinition(InstrumentDefinition instrumentDefinition) {
        this.instrumentDefinition = instrumentDefinition;
        return this;
    }

    public InstrumentInfoBuilder blocked(long blocked) {
        this.blocked = blocked;
        return this;
    }

    public InstrumentInfoBuilder braAccount(BraAccount braAccount) {
        this.braAccount = braAccount;
        return this;
    }

    public InstrumentInfoBuilder but() {
        return anInstrumentInfo().ammount(ammount).id(id).instrumentDefinition(instrumentDefinition).blocked(blocked).braAccount(braAccount);
    }

    public InstrumentInfo build() {
        InstrumentInfo instrumentInfo = new InstrumentInfo();
        instrumentInfo.setAmmount(ammount);
        instrumentInfo.setId(id);
        instrumentInfo.setInstrumentDefinition(instrumentDefinition);
        instrumentInfo.setBlocked(blocked);
        instrumentInfo.setBraAccount(braAccount);
        return instrumentInfo;
    }
}
