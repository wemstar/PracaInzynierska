package client.bra.account.service;

import client.instrument.order.service.dto.InstrumentDTO;

import java.io.Serializable;

/**
 * tranportówka dla informacji o instrumencie na rachunku
 */
public class InstrumentInfoDTO implements Serializable {
    private InstrumentDTO instrument;
    private Long ammount;
    private Long blocked;

    public Long getAmmount() {
        return ammount;
    }

    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }

    public Long getBlocked() {
        return blocked;
    }

    public void setBlocked(Long blocked) {
        this.blocked = blocked;
    }

    public InstrumentDTO getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentDTO instrument) {
        this.instrument = instrument;
    }
}
