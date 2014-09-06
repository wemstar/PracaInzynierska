package edu.agh.fis;

import edu.agh.fis.entity.SimpleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by wemstar on 06.09.14.
 */
@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class DatabaseTest  extends AbstractTestNGSpringContextTests {

    @Autowired
    public SessionFactory sessionFactory;

    @Test
    public void testDatabaseConnection()
    {
        Session session=sessionFactory.openSession();
        SimpleEntity entiry=new SimpleEntity();
        session.save(entiry);
        SimpleEntity entity2= (SimpleEntity) session.get(SimpleEntity.class,entiry.id);
        Assert.assertEquals(entiry.id,entity2.id);




    }
}
