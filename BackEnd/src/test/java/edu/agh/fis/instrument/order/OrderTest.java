package edu.agh.fis.instrument.order;

import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static edu.agh.fis.builder.entity.client.file.ClientFileBuilder.aClientFile;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentMarketBuilder.anInstrumentMarket;
import static edu.agh.fis.builder.entity.instrument.details.MarketsBuilder.aMarkets;
import static edu.agh.fis.builder.instrument.order.NewOrderDTOBuilder.aNewOrderDTO;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wemstar on 17.12.14.
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class OrderTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;
    @Autowired
    private MarketDAO marketDAO;
    @Autowired
    private ClientFileDao clientFileDao;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test(enabled = false)
    public void shouldCreateNewOrder() throws Exception {
        createMarketWithInstruments();
        createAccountWithInstruments();
        mockMvc.perform(post("/order/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber(1L)
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side("Kupno")
                        .type("Z limitem")
                        .build())))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber(1L)
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side("Kupno")
                        .type("Z limitem")
                        .id(1L)
                        .build()))));
    }

    private void createAccountWithInstruments() {
        clientFileDao.create(aClientFile()
                        .dateOfBirth(new Date())
                        .name("test")
                        .surname("testowny")

                        .build()
        );
    }

    private void createMarketWithInstruments() {
        Markets market = aMarkets()
                .active(true)
                .code("GPW")
                .name("Giełda papierów wartościowych w Warszawie")
                .build();


        InstrumentMarket insMark = anInstrumentMarket()
                .instrument(anInstrumentDefinition()
                                .isin("KGHM")
                                .name("KGHM Polska Miedź")
                                .build()
                )
                .market(market)
                .buyPrice(20.0)
                .sellPrice(21.0)
                .build();
        market.setInstruments(new HashSet<InstrumentMarket>(Arrays.asList(new InstrumentMarket[]{
                insMark
        })));
        marketDAO.create(market);
    }
}
