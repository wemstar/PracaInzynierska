package edu.agh.fis.interfaces.rest.instrument.order;

import edu.agh.fis.core.instrument.order.agregate.NewOrderAgregate;
import edu.agh.fis.core.instrument.order.factory.NewOrderFactory;
import edu.agh.fis.core.instrument.order.services.NewOrderService;
import edu.agh.fis.instrument.order.NewOrderDTO;
import edu.agh.fis.instrument.order.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wemstar on 25.09.14.
 */
@RequestMapping("/order")
@RestController
class OrderRESTImpl implements OrderREST {

    @Autowired
    private NewOrderService newOrderService;

    @Autowired
    private NewOrderFactory newOrderFactory;

    @Autowired
    private NewOrderTransformer newOrderTransformer;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public NewOrderDTO newOrder(@RequestBody NewOrderDTO newOrderDTO) {
        NewOrderAgregate newOrderAgregate = newOrderFactory
                .createNew()
                .instrument(newOrderDTO.getInstrument())
                .market(newOrderDTO.getMarket())
                .side(newOrderDTO.getSide())
                .price(newOrderDTO.getPrice())
                .type(newOrderDTO.getType())
                .ammount(newOrderDTO.getAmount())
                .build();

        return newOrderTransformer.entityToTransport(newOrderService.procesOrder(newOrderAgregate).getRootEntity());

    }

    @RequestMapping(value = "client/{clientNo}", method = RequestMethod.GET)
    public List<OrderDTO> orderListForClient(@PathVariable Long clientNo) {
        return null;
    }

}
