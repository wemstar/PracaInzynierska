package edu.agh.fis.builder.bra.acc;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;

import java.util.Set;

/**
 *Builde dla DTO rachunku
 */
public class BraAccountDTOBuilder {
    private Double avalibleCash;
    private long braAccNo;
    private Double blockCash;
    private Set<InstrumentInfoDTO> instruments;

    private BraAccountDTOBuilder() {
    }

    public static BraAccountDTOBuilder aBraAccountDTO() {
        return new BraAccountDTOBuilder();
    }

    public BraAccountDTOBuilder avalibleCash(Double avalibleCash) {
        this.avalibleCash = avalibleCash;
        return this;
    }

    public BraAccountDTOBuilder braAccNo(long braAccNo) {
        this.braAccNo = braAccNo;
        return this;
    }

    public BraAccountDTOBuilder blockCash(Double blockCash) {
        this.blockCash = blockCash;
        return this;
    }

    public BraAccountDTOBuilder instruments(Set<InstrumentInfoDTO> instruments) {
        this.instruments = instruments;
        return this;
    }

    public BraAccountDTOBuilder but() {
        return aBraAccountDTO().avalibleCash(avalibleCash).braAccNo(braAccNo).blockCash(blockCash).instruments(instruments);
    }

    public BraAccountDTO build() {
        BraAccountDTO braAccountDTO = new BraAccountDTO();
        braAccountDTO.setAvalibleCash(avalibleCash);
        braAccountDTO.setBraAccNo(braAccNo);
        braAccountDTO.setBlockCash(blockCash);
        braAccountDTO.setInstruments(instruments);
        return braAccountDTO;
    }
}
