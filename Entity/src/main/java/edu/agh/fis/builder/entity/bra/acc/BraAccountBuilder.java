package edu.agh.fis.builder.entity.bra.acc;

import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.client.file.ClientFile;

import java.util.Set;

/**
 * Created by wemstar on 11.10.14.
 */
public class BraAccountBuilder {
    private long id;
    private ClientFile clientFile;
    private double balance;
    private Set<InstrumentInfo> instruments;

    private BraAccountBuilder() {
    }

    public static BraAccountBuilder aBraAccount() {
        return new BraAccountBuilder();
    }

    public BraAccountBuilder id(long id) {
        this.id = id;
        return this;
    }

    public BraAccountBuilder clientFile(ClientFile clientFile) {
        this.clientFile = clientFile;
        return this;
    }

    public BraAccountBuilder balance(double balance) {
        this.balance = balance;
        return this;
    }

    BraAccountBuilder instruments(Set<InstrumentInfo> instruments) {
        this.instruments = instruments;
        return this;
    }

    public BraAccountBuilder but() {
        return aBraAccount().id(id).clientFile(clientFile).balance(balance).instruments(instruments);
    }

    public BraAccount build() {
        BraAccount braAccount = new BraAccount();
        braAccount.setId(id);
        braAccount.setClientFile(clientFile);
        braAccount.setBalance(balance);
        braAccount.setInstruments(instruments);
        return braAccount;
    }
}
