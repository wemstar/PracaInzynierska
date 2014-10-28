package edu.agh.fis.client.file;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;
import edu.agh.fis.interfaces.rest.client.file.ClientFileREST;
import edu.agh.fis.interfaces.rest.client.file.ClientFileRESTImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static edu.agh.fis.builder.bra.acc.BraAccountDTOBuilder.aBraAccountTransport;
import static edu.agh.fis.builder.bra.acc.InstrumentInfoDTOBuilder.anInstrumentInfoTransport;
import static edu.agh.fis.builder.client.file.ClientFileDTOBuilder.aClientFileTransport;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionTransportBuilder.anInstrumentDefinitionTransport;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by wemstar on 13.09.14.
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class ClientFileTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;


    private MockMvc mockMvc;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test(groups = "create")
    public void schouldCRUDClients() throws Exception {

        //given
        ClientFileDTO clientFileDTO1 = aClientFileTransport()
                .clientNo(1l)
                .dateOfBirth(new Date())
                .name("test1")
                .surname("SuperTest1")
                .pesel("921205668")
                .accounts(new HashSet<BraAccountDTO>(Arrays.asList(new BraAccountDTO[]{
                                aBraAccountTransport()
                                        .balance(500.0)
                                        .braAccNo(2)
                                        .instruments(new HashSet<InstrumentInfoDTO>(Arrays.asList(new InstrumentInfoDTO[]
                                                        {
                                                                anInstrumentInfoTransport()
                                                                        .definition(
                                                                                anInstrumentDefinitionTransport()
                                                                                        .isin("PLKGHML")
                                                                                        .build())
                                                                        .quantity(205)
                                                                        .build()
                                                        }))
                                        )
                                        .build()
                        }
                ))).build();

        //when
        mockMvc.perform(post("/client/file")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(clientFileDTO1)))
                .andExpect(status().isCreated())
                .andExpect(content().string(convertObjectToJsonBytes(clientFileDTO1)))
                ;

        mockMvc.perform(get("/client/file/{id}", 1l))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(clientFileDTO1)));
        clientFileDTO1.setName("sylwek");

        mockMvc.perform(put("/client/file")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(clientFileDTO1)))
        .andExpect(status().isNoContent());

        mockMvc.perform(get("/client/file/{id}", 1l))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(clientFileDTO1)));

        mockMvc.perform((delete("/client/file/{id}", 1l)))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/client/file/{id}", 1l))
                .andExpect(status().isOk())
                .andExpect(content().string(""));




    }


}
