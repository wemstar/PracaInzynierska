package edu.agh.fis.utils.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


/**
 * Aspekt tworzący logi aplikacji
 */
@Aspect
class AspectLoging {

    private final Logger log = Logger.getLogger(AspectLoging.class);

    @Around("execution(public * edu.agh.fis..*(..))")
    public Object logingPublic(ProceedingJoinPoint point) throws Throwable {
        StringBuilder builder = new StringBuilder();
        for (Object arg : point.getArgs()) builder.append(arg);
        log.info("ENTER: " + point.getSignature() + " Arguments: " + builder.toString());
        long startTime = System.nanoTime();
        Object obj;
        try {
            obj = point.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            throw throwable;
        }
        long endTime = System.nanoTime();
        log.info("EXIT: " + point.getSignature() + " Return: " + obj + " Time Execution: " + (endTime - startTime));
        return obj;
    }

    @Around("execution(private * edu.agh.fis..*(..))")
    public Object logingPrivate(ProceedingJoinPoint point) throws Throwable {
        StringBuilder builder = new StringBuilder();
        for (Object arg : point.getArgs()) builder.append(arg);
        log.debug("ENTER: " + point.getSignature() + " Arguments: " + builder.toString());
        long startTime = System.nanoTime();
        Object obj;
        try {
            obj = point.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            throw throwable;
        }
        long endTime = System.nanoTime();
        log.debug("EXIT: " + point.getSignature() + " Return: " + obj + " Time Execution: " + (endTime - startTime));
        return obj;
    }
}
