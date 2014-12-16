package edu.agh.fis.instrument.details;

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

import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionDTOBuilder.anInstrumentDefinitionDTO;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wemstar on 28.10.14.
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class InstrumentDefinitionTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void schouldCRUDInstrument() throws Exception {
        InstrumentDefinitionDTO instrumentDefinitionDTO = anInstrumentDefinitionDTO().isin("KGHM").build();

        mockMvc.perform(post("/instrument/details")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(instrumentDefinitionDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(instrumentDefinitionDTO)));

        mockMvc.perform(get("/instrument/details/{isin}", "KGHM"))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(instrumentDefinitionDTO)));


        mockMvc.perform((delete("/instrument/details/{isin}", "KGHM")))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/instrument/details/{isin}", "KGHM"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}
