package edu.agh.fis.builder.bra.acc;

import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;

/**
 * Created by wemstar on 14.12.14.
 */
public class InstrumentInfoDTOBuilder {
    private Long ammount;
    private InstrumentDefinitionDTO instrument;
    private Long blocked;

    private InstrumentInfoDTOBuilder() {
    }

    public static InstrumentInfoDTOBuilder anInstrumentInfoDTO() {
        return new InstrumentInfoDTOBuilder();
    }

    public InstrumentInfoDTOBuilder ammount(Long ammount) {
        this.ammount = ammount;
        return this;
    }

    public InstrumentInfoDTOBuilder instrument(InstrumentDefinitionDTO instrument) {
        this.instrument = instrument;
        return this;
    }

    public InstrumentInfoDTOBuilder blocked(Long blocked) {
        this.blocked = blocked;
        return this;
    }

    public InstrumentInfoDTOBuilder but() {
        return anInstrumentInfoDTO().ammount(ammount).instrument(instrument).blocked(blocked);
    }

    public InstrumentInfoDTO build() {
        InstrumentInfoDTO instrumentInfoDTO = new InstrumentInfoDTO();
        instrumentInfoDTO.setAmmount(ammount);
        instrumentInfoDTO.setInstrument(instrument);
        instrumentInfoDTO.setBlocked(blocked);
        return instrumentInfoDTO;
    }
}
