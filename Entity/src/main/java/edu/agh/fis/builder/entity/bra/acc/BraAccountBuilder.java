package edu.agh.fis.builder.entity.bra.acc;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.client.file.ClientFile;

import java.util.Set;

/**
 * Builder dla Rachunku klienta
 */
public class BraAccountBuilder {
    private double avalibleCash;
    private long id;
    private ClientFile clientFile;
    private double blockCash;
    private Set<InstrumentInfo> instruments;

    private BraAccountBuilder() {
    }

    public static BraAccountBuilder aBraAccount() {
        return new BraAccountBuilder();
    }

    public BraAccountBuilder avalibleCash(double avalibleCash) {
        this.avalibleCash = avalibleCash;
        return this;
    }

    public BraAccountBuilder id(long id) {
        this.id = id;
        return this;
    }

    public BraAccountBuilder clientFile(ClientFile clientFile) {
        this.clientFile = clientFile;
        return this;
    }

    public BraAccountBuilder blockCash(double blockCash) {
        this.blockCash = blockCash;
        return this;
    }

    public BraAccountBuilder instruments(Set<InstrumentInfo> instruments) {
        this.instruments = instruments;
        return this;
    }

    public BraAccountBuilder but() {
        return aBraAccount().avalibleCash(avalibleCash).id(id).clientFile(clientFile).blockCash(blockCash).instruments(instruments);
    }

    public BraAccount build() {
        BraAccount braAccount = new BraAccount();
        braAccount.setAvalibleCash(avalibleCash);
        braAccount.setId(id);
        braAccount.setClientFile(clientFile);
        braAccount.setBlockCash(blockCash);
        braAccount.setInstruments(instruments);
        return braAccount;
    }
}
