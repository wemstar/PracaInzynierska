package edu.agh.fis.fix;

import edu.agh.fis.core.fix.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by wemstar on 26.12.14.
 */
@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
@WebAppConfiguration("classpath:test-web-resources")
public class TestFixMessage extends AbstractTestNGSpringContextTests {


    @Autowired
    private SendMessage sendMessage;


    @Test
    public void testFix() {
        /*Assert.assertEquals(sendMessage.sendMessage(),"");*/
    }
}
