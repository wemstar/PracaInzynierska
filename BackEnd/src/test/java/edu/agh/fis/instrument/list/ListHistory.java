package edu.agh.fis.instrument.list;

import edu.agh.fis.core.bra.acc.presistance.BraAccountDao;
import edu.agh.fis.core.client.file.presistance.ClientFileDao;
import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.core.trader.history.presistance.InstrumentHistoryDAO;
import edu.agh.fis.entity.bra.acc.BraAccount;
import edu.agh.fis.entity.bra.acc.InstrumentInfo;
import edu.agh.fis.entity.client.file.ClientFile;
import edu.agh.fis.entity.instrument.details.InstrumentDefinition;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import org.springframework.beans.factory.annotation.Autowired;
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
import static edu.agh.fis.builder.entity.bra.acc.InstrumentInfoBuilder.anInstrumentInfo;
import static edu.agh.fis.builder.entity.client.file.ClientFileBuilder.aClientFile;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentHistoryBuilder.anInstrumentHistory;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentMarketBuilder.anInstrumentMarket;
import static edu.agh.fis.builder.entity.instrument.details.MarketsBuilder.aMarkets;
import static edu.agh.fis.builder.instrument.list.InstrumentHistoryDTOBuilder.anInstrumentHistoryDTO;
import static edu.agh.fis.builder.instrument.list.InstrumentListDetailsDTOBuilder.anInstrumentListDetailsDTO;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wemstar on 21.12.14.
 */

@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class ListHistory extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;

    @Autowired
    private ClientFileDao clientFileDao;

    @Autowired
    private MarketDAO marketDao;

    @Autowired
    private BraAccountDao accountDao;

    @Autowired
    private InstrumentHistoryDAO historyDAO;

    private MockMvc mockMvc;
    private Date today = new Date();

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test(enabled = false)
    public void shouldReturnActive() throws Exception {
        prepareData();

        mockMvc.perform(get("/instrument/list/bra/account/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(Arrays.asList(new InstrumentListDetailsDTO[]{anInstrumentListDetailsDTO()
                        .isin("KGHM")
                        .name("KGHM Polska miedzi")
                        .market("GPW")
                        .sellPrice(210.0)
                        .buyPrice(200.0)
                        .historyList(Arrays.asList(new InstrumentHistoryDTO[]
                                {
                                        anInstrumentHistoryDTO().date(new Date(today.getTime() + (1000 * 60 * 60 * 24))).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build(),
                                        anInstrumentHistoryDTO().date(new Date(today.getTime() + (1000 * 60 * 60 * 24) * 3)).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build(),
                                        anInstrumentHistoryDTO().date(new Date(today.getTime() + (1000 * 60 * 60 * 24) * 4)).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build(),
                                        anInstrumentHistoryDTO().date(new Date(today.getTime() + (1000 * 60 * 60 * 24) * 2)).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build(),
                                }))
                        .build()

                }))));
    }

    private void prepareData() {

        InstrumentDefinition instrumentKGHM = anInstrumentDefinition().isin("KGHM").name("KGHM Polska miedzi").build();
        InstrumentMarket insMarkKGHM = anInstrumentMarket()
                .buyPrice(200.0)
                .sellPrice(210.0)
                .instrument(instrumentKGHM)
                .build();


        Markets market = aMarkets().active(true).code("GPW").name("Giełda Papierów wartosciowych").instruments(new HashSet<InstrumentMarket>(Arrays.asList(new InstrumentMarket[]{insMarkKGHM}))).build();
        insMarkKGHM.setMarket(market);


        InstrumentInfo instrumentInfo = anInstrumentInfo().instrumentDefinition(instrumentKGHM).ammount(20).blocked(1).build();
        BraAccount braAccount1 = aBraAccount()
                .avalibleCash(2000.0)
                .blockCash(15.0)
                .instruments(new HashSet<InstrumentInfo>(Arrays.asList(new InstrumentInfo[]{instrumentInfo})))
                .build();
        instrumentInfo.setBraAccount(braAccount1);
        ClientFile clientFile = aClientFile()
                .name("Sylwek")
                .surname("Macura")
                .dateOfBirth(new Date())
                .pesel("92147856998")
                .account(new HashSet<BraAccount>(Arrays.asList(new BraAccount[]{braAccount1})))
                .build();
        braAccount1.setClientFile(clientFile);

        clientFileDao.create(clientFile);
        marketDao.create(market);
        accountDao.create(braAccount1);

        historyDAO.create(anInstrumentHistory().instrumentMarket(insMarkKGHM).date(new Date(today.getTime() + (1000 * 60 * 60 * 24))).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build());
        historyDAO.create(anInstrumentHistory().instrumentMarket(insMarkKGHM).date(new Date(today.getTime() + (1000 * 60 * 60 * 24) * 2)).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build());
        historyDAO.create(anInstrumentHistory().instrumentMarket(insMarkKGHM).date(new Date(today.getTime() + (1000 * 60 * 60 * 24) * 3)).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build());
        historyDAO.create(anInstrumentHistory().instrumentMarket(insMarkKGHM).date(new Date(today.getTime() + (1000 * 60 * 60 * 24) * 4)).closePrice(10.0).maxPrice(20.0).minPrice(5.0).openPrice(20.0).build());


    }
}
