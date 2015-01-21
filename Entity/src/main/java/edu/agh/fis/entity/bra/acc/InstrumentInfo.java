package edu.agh.fis.entity.bra.acc;

import edu.agh.fis.entity.instrument.details.InstrumentDefinition;

import javax.persistence.*;

/**
 * Przechowuje informacje o instrumencie na rachunku
 */
@Entity
@Table(name = "INSTRUMENT_INFO", uniqueConstraints = @UniqueConstraint(columnNames = {"INSTR_INFO_BRA_ACCOUNT", "INSTR_INFO_DEFINITION"}))
public class InstrumentInfo {

    @Id
    @Column(name = "INSTR_INFO_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INSTR_INFO_DEFINITION")
    private InstrumentDefinition instrumentDefinition;

    @Column(name = "INSTR_INFO_AMMOUNT")
    private long ammount;

    @Column(name = "INSTR_INFO_BLOCKED")
    private long blocked;

    @ManyToOne(fetch = FetchType.EAGER)
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

    public long getAmmount() {
        return ammount;
    }

    public void setAmmount(long ammount) {
        this.ammount = ammount;
    }

    public long getBlocked() {
        return blocked;
    }

    public void setBlocked(long blocked) {
        this.blocked = blocked;
    }

    public BraAccount getBraAccount() {
        return braAccount;
    }

    public void setBraAccount(BraAccount braAccount) {
        this.braAccount = braAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstrumentInfo info = (InstrumentInfo) o;

        if (!instrumentDefinition.equals(info.instrumentDefinition)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return instrumentDefinition.hashCode();
    }
}
