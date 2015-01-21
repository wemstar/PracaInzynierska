package edu.agh.fis.builder.instrument.list;

import edu.agh.fis.instrument.list.InstrumentHistoryDTO;

import java.util.Date;

/**
 * Builder dla DTO histori instrumentu
 */
public class InstrumentHistoryDTOBuilder {
    private Double closePrice;
    private Date date;
    private Double openPrice;
    private Double minPrice;
    private Double maxPrice;

    private InstrumentHistoryDTOBuilder() {
    }

    public static InstrumentHistoryDTOBuilder anInstrumentHistoryDTO() {
        return new InstrumentHistoryDTOBuilder();
    }

    public InstrumentHistoryDTOBuilder closePrice(Double closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public InstrumentHistoryDTOBuilder date(Date date) {
        this.date = date;
        return this;
    }

    public InstrumentHistoryDTOBuilder openPrice(Double openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public InstrumentHistoryDTOBuilder minPrice(Double minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public InstrumentHistoryDTOBuilder maxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public InstrumentHistoryDTOBuilder but() {
        return anInstrumentHistoryDTO().closePrice(closePrice).date(date).openPrice(openPrice).minPrice(minPrice).maxPrice(maxPrice);
    }

    public InstrumentHistoryDTO build() {
        InstrumentHistoryDTO instrumentHistoryDTO = new InstrumentHistoryDTO();
        instrumentHistoryDTO.setClosePrice(closePrice);
        instrumentHistoryDTO.setDate(date);
        instrumentHistoryDTO.setOpenPrice(openPrice);
        instrumentHistoryDTO.setMinPrice(minPrice);
        instrumentHistoryDTO.setMaxPrice(maxPrice);
        return instrumentHistoryDTO;
    }
}
