package edu.agh.fis.instrument.market;

import edu.agh.fis.core.instrument.market.presistance.MarketDAO;
import edu.agh.fis.entity.instrument.details.InstrumentMarket;
import edu.agh.fis.entity.instrument.details.Markets;
import edu.agh.fis.instrument.details.InstrumentDefinitionDTO;
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
import java.util.HashSet;

import static edu.agh.fis.builder.entity.instrument.details.InstrumentDefinitionBuilder.anInstrumentDefinition;
import static edu.agh.fis.builder.entity.instrument.details.InstrumentMarketBuilder.anInstrumentMarket;
import static edu.agh.fis.builder.entity.instrument.details.MarketsBuilder.aMarkets;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionDTOBuilder.anInstrumentDefinitionDTO;
import static edu.agh.fis.builder.instrument.market.MarketDTOBuilder.aMarketDTO;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wemstar on 15.12.14.
 */

@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class MarketRestTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private MarketDAO marketDAO;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test(enabled = false)
    public void shouldReturnActive() throws Exception {

        Markets market = aMarkets()
                .active(true)
                .code("GPWa")
                .name("Giełda papierów wartościowych w Warszawie")
                .build();


        InstrumentMarket insMark = anInstrumentMarket()
                .instrument(anInstrumentDefinition()
                                .isin("KGHMa")
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

        marketDAO.create(aMarkets()
                        .active(false)
                        .code("NYSEa")
                        .name("NEW York Stock Exchange")
                        .instruments(new HashSet<InstrumentMarket>(Arrays.asList(new InstrumentMarket[]{


                        })))
                        .build()
        );

        mockMvc.perform(get("/market/all/active"))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(Arrays.asList(new MarketDTO[]{
                        aMarketDTO()
                                .active(true)
                                .code("GPWa")
                                .name("Giełda papierów wartościowych w Warszawie")
                                .instruments(Arrays.asList(new InstrumentDefinitionDTO[]{
                                        anInstrumentDefinitionDTO()
                                                .name("KGHM Polska Miedź")
                                                .isin("KGHMa")
                                                .build()
                                }))
                                .build()

                }))));
    }
}
