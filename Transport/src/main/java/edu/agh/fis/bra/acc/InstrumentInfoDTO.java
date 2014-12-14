package edu.agh.fis.bra.acc;

import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

/**
 * Created by wemstar on 11.10.14.
 */
public class InstrumentInfoDTO {

    private InstrumentDefinitionDTO instrument;
    private Long ammount;
    private Long blocked;

    @Override
    public String toString() {
        return "InstrumentInfoDTO{" +
                "ammount=" + ammount +
                ", instrument=" + instrument +
                ", blocked=" + blocked +
                '}';
    }

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

    public InstrumentDefinitionDTO getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentDefinitionDTO instrument) {
        this.instrument = instrument;
    }






}
