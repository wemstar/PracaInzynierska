package edu.agh.fis.client.file;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by wemstar on 13.09.14.
 */
@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
@WebAppConfiguration("classpath:test-web-resources")
public class ClientFileTest {
}
