package edu.agh.fis.client.file;

import edu.agh.fis.bra.acc.BraAccountDTO;
import edu.agh.fis.bra.acc.InstrumentInfoDTO;
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
import static edu.agh.fis.builder.client.file.ClientFileDTOBuilder.aClientFileTransport;
import static edu.agh.fis.builder.instrument.details.InstrumentDefinitionTransportBuilder.anInstrumentDefinitionTransport;
import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    
    public void schouldCRUDClients() throws Exception {

        //given
        ClientFileDTO clientFileDTO1 = aClientFileTransport()
                //.clientNo(1l)
                .dateOfBirth(new Date())
                .name("test1")
                .surname("SuperTest1")
                .pesel("921205668")
                .accounts(new HashSet<BraAccountDTO>(Arrays.asList(new BraAccountDTO[]{
                                aBraAccountDTO()
                                        .avalibleCash(200.0)
                                        .blockCash(85.0)
                                                //.braAccNo(2)
                                        .instruments(new HashSet<InstrumentInfoDTO>(Arrays.asList(new InstrumentInfoDTO[]
                                                        {
                                                                anInstrumentInfoDTO()
                                                                        .instrument(
                                                                                anInstrumentDefinitionTransport()
                                                                                        .isin("PLKGHML")
                                                                                        .build())
                                                                        .ammount(205L)
                                                                        .blocked(10L)
                                                                        .build()
                                                        }))
                                        )
                                        .build()
                        }
                ))).build();

        //when
        clientFileDTO1.setClientNo(1);
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
