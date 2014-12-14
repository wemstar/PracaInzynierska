package client.bra.account.service;

import client.instrument.order.service.dto.InstrumentDTO;

import java.io.Serializable;

/**
 * Created by wemstar on 08.12.14.
 */
public class InstrumentInfoDTO implements Serializable {
    private InstrumentDTO instrument;
    private Double ammount;
    private Double blocked;

    public Double getAmmount() {
        return ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public Double getBlocked() {
        return blocked;
    }

    public void setBlocked(Double blocked) {
        this.blocked = blocked;
    }

    public InstrumentDTO getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentDTO instrument) {
        this.instrument = instrument;
    }
}
