package edu.agh.fis.entity.bra.acc;

import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.entity.instrument.order.NewOrder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne()
    @JoinColumn(name = "BRA_CLIENT_FILE_ID", nullable = false)
    private ClientFile clientFile;

    @Column(name = "BRA_AVALIBLE_CASH")
    private double avalibleCash;

    @Column(name = "BRA_BLOCK_CASH")
    private double blockCash;


    @OneToMany(mappedBy = "braAccount", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<InstrumentInfo> instruments;

    @OneToMany(mappedBy = "braAccount", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    private Set<NewOrder> orders;

    public Set<NewOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<NewOrder> orders) {
        this.orders = orders;
    }

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
