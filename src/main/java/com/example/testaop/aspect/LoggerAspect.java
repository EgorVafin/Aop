package com.example.testaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {
    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @Pointcut("within(com.example.testaop.controller.*)")
    public void isControllerLayer() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void hasRequestMapping() {}

    @Pointcut("target(org.springframework.web.bind.annotation.RestController)")
    public void isRequestController() {}

//    @Before("isControllerLayer() && hasRequestMapping()")
//    public void addLoggingBefore() throws Throwable {
//        logger.info("RequestMapping method started");
//    }
//
//    @After("isControllerLayer() && hasRequestMapping()")
//    public void addLoggingAfter() throws Throwable{
//        logger.info("RequestMapping method finished");
//    }

    @Around("isControllerLayer() && hasRequestMapping()")
    public Object addLoggingAround(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Around aspect. RequestMapping method started");
        long startTime = System.nanoTime();

        Object proceed = joinPoint.proceed();

        long endTime = System.nanoTime();
        logger.info("Around aspect. RequestMapping method finished. It is takes " + (endTime - startTime) + " ns");

        return proceed;
    }
}
