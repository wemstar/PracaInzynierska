package edu.agh.fis.interfaces.rest.instrument.order;


import edu.agh.fis.core.instrument.order.services.NewOrderService;
import edu.agh.fis.instrument.order.NewOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private NewOrderTransformer newOrderTransformer;

    @Override
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public NewOrderDTO newOrder(@RequestBody NewOrderDTO newOrderDTO) {


        return newOrderTransformer.entityToTransport(newOrderService.procesOrder(newOrderTransformer.transportToEntity(newOrderDTO)));

    }

    @Override
    @RequestMapping(value = "client/{clientNo}", method = RequestMethod.GET)
    public List<NewOrderDTO> orderListForClient(@PathVariable Long clientNo) {

        return newOrderTransformer.entityToTransportList(newOrderService.getOrdeListForClient(clientNo));
    }

}
