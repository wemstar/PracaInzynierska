package edu.agh.fis.utils.logger;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * Created by wemstar on 02.10.14.
 */

public class LoggerPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Logger log=Logger.getLogger(LoggerPostProcessor.class);
        for(Field field:bean.getClass().getDeclaredFields())
        {
            if(field.getAnnotation(InjectLogger.class)!=null)
            {
                try {
                    field.set(bean, Logger.getLogger(bean.getClass()));
                    log.trace("CREATE LOGGER");
                } catch (IllegalAccessException e) {
                    throw new FatalBeanException("Problem przy tworzeniu loggera",e);

                }
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
