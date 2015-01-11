package edu.agh.fis.user;

import edu.agh.fis.core.user.presistance.UserDAO;
import edu.agh.fis.entity.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static edu.agh.fis.utils.testing.TestUtil.convertObjectToJsonBytes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wemstar on 11.01.15.
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
@DirtiesContext()
public class UserValidationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;
    @Autowired
    private UserDAO dao;

    @BeforeMethod
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test(enabled = false)
    public void schouldLoginUser() throws Exception {
        UserEntity entity = new UserEntity();
        entity.setLogin("JAN");
        entity.setPassword("521ad2c98e9ec034c8682b0dc1b535f66e282240");
        dao.create(entity);
        UserDTO dto = new UserDTO();
        dto.setLogin("JAN");
        dto.setPassword("JAN");
        mockMvc.perform(post("/user/autorize")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(dto)))
                .andExpect(status().isOk())
                .andExpect(content().string(convertObjectToJsonBytes(true)));
    }
}
