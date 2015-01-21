package edu.agh.fis.builder.instrument.list;

import edu.agh.fis.instrument.list.InstrumentHistoryDTO;
import edu.agh.fis.instrument.list.InstrumentListDetailsDTO;

import java.util.List;

/**
 * Builder dla DTO informcaji o hostorii
 */
public class InstrumentListDetailsDTOBuilder {
    private Double buyPrice;
    private String isin;
    private String name;
    private String market;
    private Double sellPrice;
    private List<InstrumentHistoryDTO> historyList;

    private InstrumentListDetailsDTOBuilder() {
    }

    public static InstrumentListDetailsDTOBuilder anInstrumentListDetailsDTO() {
        return new InstrumentListDetailsDTOBuilder();
    }

    public InstrumentListDetailsDTOBuilder buyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
        return this;
    }

    public InstrumentListDetailsDTOBuilder isin(String isin) {
        this.isin = isin;
        return this;
    }

    public InstrumentListDetailsDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public InstrumentListDetailsDTOBuilder market(String market) {
        this.market = market;
        return this;
    }

    public InstrumentListDetailsDTOBuilder sellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
        return this;
    }

    public InstrumentListDetailsDTOBuilder historyList(List<InstrumentHistoryDTO> historyList) {
        this.historyList = historyList;
        return this;
    }

    public InstrumentListDetailsDTOBuilder but() {
        return anInstrumentListDetailsDTO().buyPrice(buyPrice).isin(isin).name(name).market(market).sellPrice(sellPrice).historyList(historyList);
    }

    public InstrumentListDetailsDTO build() {
        InstrumentListDetailsDTO instrumentListDetailsDTO = new InstrumentListDetailsDTO();
        instrumentListDetailsDTO.setBuyPrice(buyPrice);
        instrumentListDetailsDTO.setIsin(isin);
        instrumentListDetailsDTO.setName(name);
        instrumentListDetailsDTO.setMarket(market);
        instrumentListDetailsDTO.setSellPrice(sellPrice);
        instrumentListDetailsDTO.setHistoryList(historyList);
        return instrumentListDetailsDTO;
    }
}
