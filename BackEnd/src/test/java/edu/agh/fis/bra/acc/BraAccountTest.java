package edu.agh.fis.bra.acc;

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

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import static edu.agh.fis.builder.bra.acc.BraAccountDTOBuilder.aBraAccountTransport;
import static edu.agh.fis.builder.bra.acc.InstrumentInfoDTOBuilder.anInstrumentInfoTransport;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionTransportBuilder.anInstrumentDefinitionTransport;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wemstar on 12.10.14.
 */

@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class BraAccountTest extends AbstractTestNGSpringContextTests {


    @Autowired
    WebApplicationContext wac;


    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void shouldCreateBraAccount() throws Exception {
        BraAccountDTO dto1 = aBraAccountTransport()
                .braAccNo(560L)
                .balance(10).instruments(new HashSet<InstrumentInfoDTO>(Arrays.asList(new InstrumentInfoDTO[]
                        {
                                anInstrumentInfoTransport()
                                        .definition(anInstrumentDefinitionTransport()
                                                .isin("KGHM")
                                                .build())
                                        .quantity(205)
                                        .build()

                        })))
                .build();

        mockMvc.perform(post("/bra/acc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(dto1)))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(dto1)));

        mockMvc.perform(get("/bra/acc/{braNo}", 560l))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(dto1)));
        dto1.setBalance(25);

        mockMvc.perform(put("/bra/acc")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(dto1)))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/bra/acc/{braNo}", 560l))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(dto1)));

        mockMvc.perform((delete("/bra/acc/{braNo}", 560l)))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/bra/acc/{braNo}", 560l))
                .andExpect(status().isOk())
                .andExpect(content().string(""));


    }

}
