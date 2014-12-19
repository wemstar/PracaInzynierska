package edu.agh.fis.interfaces.rest.instrument.order;


import edu.agh.fis.core.bra.acc.presistance.BraAccountDao;
import edu.agh.fis.core.instrument.details.presistance.InstrumentDefinitionDAO;
import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.OrderType;
import edu.agh.fis.enums.order.Side;
import edu.agh.fis.instrument.order.NewOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static edu.agh.fis.builder.entity.instrument.order.NewOrderBuilder.aNewOrder;
import static edu.agh.fis.builder.instrument.order.NewOrderDTOBuilder.aNewOrderDTO;

/**
 * Created by wemstar on 17.12.14.
 */
@Component
public class NewOrderTransformerImpl implements NewOrderTransformer {
    @Autowired
    private BraAccountDao braAccountDao;
    @Autowired
    private InstrumentDefinitionDAO instrumetnDao;

    @Autowired
    private MarketDAO marketDAO;

    @Override
    public NewOrderDTO entityToTransport(NewOrder rootEntity) {
        return aNewOrderDTO()
                .id(rootEntity.getId())
                .type(rootEntity.getType().toString())
                .side(rootEntity.getSide().toString())
                .price(rootEntity.getPrice())
                .accountNumber(new Long(rootEntity.getBraAccount().getId()).toString())
                .amount(rootEntity.getAmount())
                .instrument(rootEntity.getInstrument().getIsin())
                .market(rootEntity.getMarket().getCode())
                .build();
    }

    @Override
    public NewOrder transportToEntity(NewOrderDTO newOrderDTO) {
        return aNewOrder()
                .amount(newOrderDTO.getAmount())
                .price(newOrderDTO.getPrice())
                .braAccount(braAccountDao.find(Long.parseLong(newOrderDTO.getAccountNumber())))
                .instrument(instrumetnDao.find(newOrderDTO.getInstrument()))
                .id(newOrderDTO.getId())
                .side(Side.valueOf(newOrderDTO.getSide()))
                .type(OrderType.valueOf(newOrderDTO.getType()))
                .market(marketDAO.find(newOrderDTO.getMarket()))
                .build();
    }

    @Override
    public List<NewOrderDTO> entityToTransportList(List<NewOrder> ordeListForClient) {
        List<NewOrderDTO> orderDTOs = new ArrayList<NewOrderDTO>();
        for (NewOrder orderEntity : ordeListForClient) orderDTOs.add(entityToTransport(orderEntity));
        return orderDTOs;
    }
}
