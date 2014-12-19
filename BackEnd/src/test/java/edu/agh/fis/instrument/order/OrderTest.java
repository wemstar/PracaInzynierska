package edu.agh.fis.instrument.order;

import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.enums.order.OrderType;
import edu.agh.fis.enums.order.Side;
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

import static edu.agh.fis.builder.entity.bra.acc.BraAccountBuilder.aBraAccount;
import static edu.agh.fis.builder.entity.client.file.ClientFileBuilder.aClientFile;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentMarketBuilder.anInstrumentMarket;
import static edu.agh.fis.builder.entity.instrument.details.MarketsBuilder.aMarkets;
import static edu.agh.fis.builder.instrument.order.NewOrderDTOBuilder.aNewOrderDTO;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Test(enabled = false, groups = "inserting")
    public void shouldCreateNewOrder() throws Exception {
        createMarketWithInstruments();
        createAccountWithInstruments();
        mockMvc.perform(post("/order/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("1")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side(Side.BUY.toString())
                        .type(OrderType.Limit.toString())
                        .build())))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("1")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side(Side.BUY.toString())
                        .type(OrderType.Limit.toString())
                        .id(1L)
                        .build())));
    }

    @Test(dependsOnGroups = "inserting", enabled = false)
    public void shouldReturn() throws Exception {
        mockMvc.perform(get("/order/client/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(Arrays.asList(new NewOrderDTO[]
                        {
                                aNewOrderDTO()
                                        .accountNumber("1")
                                        .instrument("KGHM")
                                        .market("GPW")
                                        .amount(2L)
                                        .price(5.0)
                                        .side(Side.BUY.toString())
                                        .type(OrderType.Limit.toString())
                                        .id(1L)
                                        .build()
                        }))));
        ;
    }

    private void createAccountWithInstruments() {

        BraAccount account = aBraAccount()
                .blockCash(12.0)
                .avalibleCash(400.0)
                .build();

        ClientFile clientFile = aClientFile()
                .dateOfBirth(new Date())
                .name("test")
                .surname("testowny")
                .build();
        account.setClientFile(clientFile);
        clientFile.setAccount(new HashSet<BraAccount>(Arrays.asList(new BraAccount[]{account})));
        clientFileDao.create(clientFile);
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
