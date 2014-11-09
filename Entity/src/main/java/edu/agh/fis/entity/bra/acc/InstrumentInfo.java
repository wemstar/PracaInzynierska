package edu.agh.fis.entity.bra.acc;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

import javax.persistence.*;

/**
 * Created by wemstar on 10.10.14.
 */
@Entity
@Table(name = "INSTRUMENT_INFO", uniqueConstraints = @UniqueConstraint(columnNames = {"INSTR_INFO_BRA_ACCOUNT", "INSTR_INFO_DEFINITION"}))
public class InstrumentInfo {

    @Id
    @GeneratedValue
    @Column(name = "INSTR_INFO_ID")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INSTR_INFO_DEFINITION")
    private InstrumentDefinition instrumentDefinition;

    @Column(name = "INSTR_INFO_QUANTITY")
    private long quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INSTR_INFO_BRA_ACCOUNT")
    private BraAccount braAccount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public InstrumentDefinition getInstrumentDefinition() {
        return instrumentDefinition;
    }

    public void setInstrumentDefinition(InstrumentDefinition instrumentDefinition) {
        this.instrumentDefinition = instrumentDefinition;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BraAccount getBraAccount() {
        return braAccount;
    }

    public void setBraAccount(BraAccount braAccount) {
        this.braAccount = braAccount;
    }
}
