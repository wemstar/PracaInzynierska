package edu.agh.fis.interfaces.rest.instrument.order;

import edu.agh.fis.instrument.order.NewOrderDTO;

import java.util.List;

/**
 * Created by wemstar on 25.09.14.
 */
interface OrderREST {

    NewOrderDTO newOrder(NewOrderDTO newOrderDTO);


    List<NewOrderDTO> orderListForClient(Long clientNo);
}
