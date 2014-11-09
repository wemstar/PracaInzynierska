package edu.agh.fis.entity.bra.acc;

import edu.agh.fis.entity.client.file.ClientFile;

import javax.persistence.*;
import java.util.Set;

/**
 * Klasa przechowująca stan rachunku
 */
@Entity
@Table(name = "BRA_ACCOUNT")
public class BraAccount {

    @Id
    @Column(name = "BRA_ACCOUNT_ID")
    public long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRA_CLIENT_FILE_ID")
    public ClientFile clientFile;

    @Column(name = "BRA_BALANCE")
    public double balance;

    @OneToMany(mappedBy = "braAccount", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public Set<InstrumentInfo> instruments;

    public Set<InstrumentInfo> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<InstrumentInfo> instruments) {
        this.instruments = instruments;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ClientFile getClientFile() {
        return clientFile;
    }

    public void setClientFile(ClientFile clientFile) {
        this.clientFile = clientFile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
