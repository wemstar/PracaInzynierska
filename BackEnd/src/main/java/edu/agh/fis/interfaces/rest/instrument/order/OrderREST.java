package edu.agh.fis.interfaces.rest.instrument.order;

import edu.agh.fis.instrument.order.NewOrderDTO;

import java.util.List;

/**
 * Przetwarza zapytanie REST dla zleceń
 */
interface OrderREST {

    NewOrderDTO newOrder(NewOrderDTO newOrderDTO);


    List<NewOrderDTO> orderListForClient(Long clientNo);
}
