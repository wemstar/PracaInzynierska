package edu.agh.fis.interfaces.rest.instrument.market;

import edu.agh.fis.core.instrument.market.service.MarketService;
import edu.agh.fis.instrument.market.MarketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wemstar on 15.12.14.
 */
@RequestMapping("/market")
@RestController
public class MarketRestImpl implements MarketRest {

    @Autowired
    private MarketService marketService;

    @Autowired
    private MarketTransformer transformer;


    @Override
    @RequestMapping(value = "/all/active", method = RequestMethod.GET)
    public List<MarketDTO> getActiveMarket() {
        return transformer.entityToTransportList(marketService.getActiveMarket());
    }


}
