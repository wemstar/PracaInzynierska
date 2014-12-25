package edu.agh.fis.instrument.order.limit;

import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.core.instrument.details.presistance.InstrumentDefinitionDAO;
import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.enums.order.OrderType;
import edu.agh.fis.enums.order.Side;
import edu.agh.fis.instrument.order.NewOrderDTO;
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

import static edu.agh.fis.builder.bra.acc.BraAccountDTOBuilder.aBraAccountDTO;
import static edu.agh.fis.builder.bra.acc.InstrumentInfoDTOBuilder.anInstrumentInfoDTO;
import static edu.agh.fis.builder.entity.bra.acc.BraAccountBuilder.aBraAccount;
import static edu.agh.fis.builder.entity.bra.acc.InstrumentInfoBuilder.anInstrumentInfo;
import static edu.agh.fis.builder.entity.client.file.ClientFileBuilder.aClientFile;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentMarketBuilder.anInstrumentMarket;
import static edu.agh.fis.builder.entity.instrument.details.MarketsBuilder.aMarkets;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionDTOBuilder.anInstrumentDefinitionDTO;
import static edu.agh.fis.builder.instrument.order.NewOrderDTOBuilder.aNewOrderDTO;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wemstar on 20.12.14.
 */

@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class OrderLimitTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private ClientFileDao clientFileDao;

    @Autowired
    private MarketDAO marketDao;

    @Autowired
    private InstrumentDefinitionDAO instrumentDao;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test(enabled = false)
    public void shouldSellInstrument() throws Exception {
        prepareData();
        executeBuyOrder();
        executeSellOrder();
        mockMvc.perform(get("/order/client/1"))
                .andExpect(content().string("[]"));

        mockMvc.perform(get("/bra/acc/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        convertObjectToJsonBytes(aBraAccountDTO()
                                .braAccNo(1L)
                                .blockCash(15.0)
                                .avalibleCash(2000.0)
                                .instruments(new HashSet<InstrumentInfoDTO>())
                                .build())
                ));
        mockMvc.perform(get("/bra/acc/2"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        convertObjectToJsonBytes(aBraAccountDTO()
                                .braAccNo(2L)
                                .blockCash(15.0)
                                .avalibleCash(2000.0)
                                .instruments(new HashSet<InstrumentInfoDTO>(Arrays.asList(new InstrumentInfoDTO[]{
                                        anInstrumentInfoDTO()
                                                .blocked(0L)
                                                .ammount(2L)
                                                .instrument(anInstrumentDefinitionDTO()
                                                        .name("KGHM Polska miedzi")
                                                        .isin("KGHM")
                                                        .build())
                                                .build()
                                })))
                                .build())
                ));

        mockMvc.perform(get("/bra/acc/2"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        convertObjectToJsonBytes(aBraAccountDTO()
                                .braAccNo(2L)
                                .blockCash(15.0)
                                .avalibleCash(2000.0)
                                .instruments(new HashSet<InstrumentInfoDTO>(Arrays.asList(new InstrumentInfoDTO[]{
                                        anInstrumentInfoDTO()
                                                .blocked(0L)
                                                .ammount(2L)
                                                .instrument(anInstrumentDefinitionDTO()
                                                        .name("KGHM Polska miedzi")
                                                        .isin("KGHM")
                                                        .build())
                                                .build()
                                })))
                                .build())));

    }

    @Test(enabled = false)
    public void shouldReturnTwoOrders() throws Exception {
        prepareData();
        executeBuyOrder();
        mockMvc.perform(post("/order/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("2")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side(Side.BUY.toString())
                        .type(OrderType.Limit.toString())
                        .build())))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("2")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side(Side.BUY.toString())
                        .type(OrderType.Limit.toString())
                        .id(2L)
                        .build())));
        mockMvc.perform(get("/order/client/1"))
                .andExpect(content().string(convertObjectToJsonBytes(Arrays.asList(new NewOrderDTO[]{
                        aNewOrderDTO()
                                .accountNumber("2")
                                .instrument("KGHM")
                                .market("GPW")
                                .amount(2L)
                                .price(5.0)
                                .side(Side.BUY.toString())
                                .type(OrderType.Limit.toString())
                                .id(1L)
                                .build(),
                        aNewOrderDTO()
                                .accountNumber("2")
                                .instrument("KGHM")
                                .market("GPW")
                                .amount(2L)
                                .price(5.0)
                                .side(Side.BUY.toString())
                                .type(OrderType.Limit.toString())
                                .id(2L)
                                .build()

                }))));
    }
    private void executeSellOrder() throws Exception {
        mockMvc.perform(post("/order/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("1")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side(Side.SELL.toString())
                        .type(OrderType.Limit.toString())
                        .build())))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("1")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(0L)
                        .price(5.0)
                        .side(Side.SELL.toString())
                        .type(OrderType.Limit.toString())
                        .id(2L)
                        .build())));


    }

    private void executeBuyOrder() throws Exception {
        mockMvc.perform(post("/order/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("2")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side(Side.BUY.toString())
                        .type(OrderType.Limit.toString())
                        .build())))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(aNewOrderDTO()
                        .accountNumber("2")
                        .instrument("KGHM")
                        .market("GPW")
                        .amount(2L)
                        .price(5.0)
                        .side(Side.BUY.toString())
                        .type(OrderType.Limit.toString())
                        .id(1L)
                        .build())));
    }

    private void prepareData() {

        InstrumentDefinition instrumentKGHM = anInstrumentDefinition().isin("KGHM").name("KGHM Polska miedzi").build();
        InstrumentDefinition instrumentJSW = anInstrumentDefinition().isin("JSW").name("Jastrzębska spółka węglowa").build();

        InstrumentMarket insMarkKGHM = anInstrumentMarket().buyPrice(200.0).sellPrice(210.0).instrument(instrumentKGHM).build();
        InstrumentMarket insMarkJSW = anInstrumentMarket().buyPrice(200.0).sellPrice(210.0).instrument(instrumentJSW).build();

        Markets market = aMarkets().active(true).code("GPW").name("Giełda Papierów wartosciowych").instruments(new HashSet<InstrumentMarket>(Arrays.asList(new InstrumentMarket[]{insMarkJSW, insMarkKGHM}))).build();
        insMarkKGHM.setMarket(market);
        insMarkJSW.setMarket(market);

        InstrumentInfo instrumentInfo = anInstrumentInfo().instrumentDefinition(instrumentKGHM).ammount(20).blocked(1).build();
        BraAccount braAccount1 = aBraAccount()
                .avalibleCash(2000.0)
                .blockCash(15.0)
                .instruments(new HashSet<InstrumentInfo>(Arrays.asList(new InstrumentInfo[]{instrumentInfo})))
                .build();
        BraAccount braAccount2 = aBraAccount()
                .avalibleCash(2000.0)
                .blockCash(15.0)
                .build();
        ClientFile clientFile = aClientFile()
                .name("Sylwek")
                .surname("Macura")
                .dateOfBirth(new Date())
                .pesel("92147856998")
                .account(new HashSet<BraAccount>(Arrays.asList(new BraAccount[]{braAccount1, braAccount2})))
                .build();
        braAccount1.setClientFile(clientFile);
        braAccount2.setClientFile(clientFile);
        instrumentDao.create(instrumentKGHM);
        instrumentDao.create(instrumentJSW);
        clientFileDao.create(clientFile);
        marketDao.create(market);

    }
}
