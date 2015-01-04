package edu.agh.fis.instrument.list;

import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by wemstar on 04.01.15.
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class AllMarketHistory extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;
    private MockMvc mockMvc;
    private MarketDAO marketDAO;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

   /* @Test
    public void tesAllMarkets()
    {
        marketDAO.create(aMarkets()
                .name("GPW")
                .code("GPW")
                .instruments(new HashSet<InstrumentMarket>(Arrays.asList(new InstrumentMarket[]{
                        anInstrumentMarket().buyPrice(20.0).instrument().build(),
                        anInstrumentMarket().build(),
                })))
                .build());
    }*/

}
