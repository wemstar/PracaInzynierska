package edu.agh.fis.services;

import edu.agh.fis.transport.TestClass;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wemstar on 04.09.14.
 */
@RestController
@RequestMapping("/test")
public class SimpleTest {

    @RequestMapping("/cre")
    public TestClass creste()
    {
        return new TestClass();
    }
}
