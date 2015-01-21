package edu.agh.fis.interfaces.rest.instrument.order;

import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.instrument.order.NewOrderDTO;

import java.util.List;

/**
 * Transformuje obiekty transportowe in bazodanowe
 */
public interface NewOrderTransformer {
    NewOrderDTO entityToTransport(NewOrder rootEntity);

    NewOrder transportToEntity(NewOrderDTO newOrderDTO);

    List<NewOrderDTO> entityToTransportList(List<NewOrder> ordeListForClient);
}
