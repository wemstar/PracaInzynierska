package edu.agh.fis.fix;

import edu.agh.fis.core.fix.SendMessage;
import edu.agh.fis.entity.instrument.order.NewOrder;
import edu.agh.fis.enums.order.OrderType;
import edu.agh.fis.enums.order.Side;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static edu.agh.fis.builder.entity.bra.acc.BraAccountBuilder.aBraAccount;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;
import static edu.agh.fis.builder.entity.instrument.details.MarketsBuilder.aMarkets;
import static edu.agh.fis.builder.entity.instrument.order.NewOrderBuilder.aNewOrder;

/**
 * Created by wemstar on 26.12.14.
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
@DirtiesContext()
public class TestFixMessage extends AbstractTestNGSpringContextTests {


    @Autowired
    WebApplicationContext wac;
    @Autowired
    private SendMessage sendMessage;
    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test(enabled = false)
    public void testFix() {
        NewOrder order = aNewOrder()
                .market(aMarkets().code("CODE").name("NAME").build())
                .type(OrderType.Limit)
                .braAccount(aBraAccount().id(25L).build())
                .price(1.0)
                .side(Side.BUY)
                .amount(5L)
                .instrument(anInstrumentDefinition().isin("KGHM").name("KGHM").build())
                .build();
        sendMessage.sendMessage(order);
        Assert.assertEquals(order.getFix(), "");

    }
}
