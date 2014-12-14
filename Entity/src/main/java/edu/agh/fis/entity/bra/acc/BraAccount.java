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
    private long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRA_CLIENT_FILE_ID")
    private ClientFile clientFile;

    @Column(name = "BRA_AVALIBLE_CASH")
    private double avalibleCash;

    @Column(name = "BRA_BLOCK_CASH")
    private double blockCash;



    @OneToMany(mappedBy = "braAccount", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<InstrumentInfo> instruments;

    public Set<InstrumentInfo> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<InstrumentInfo> instruments) {
        this.instruments = instruments;
    }


    public double getAvalibleCash() {
        return avalibleCash;
    }

    public void setAvalibleCash(double avalibleCash) {
        this.avalibleCash = avalibleCash;
    }

    public double getBlockCash() {
        return blockCash;
    }

    public void setBlockCash(double blockCash) {
        this.blockCash = blockCash;
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
