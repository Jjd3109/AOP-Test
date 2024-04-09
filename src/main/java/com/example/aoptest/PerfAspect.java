package com.example.aoptest;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PerfAspect {

    /* 테스트 1번 */

//    @Around("execution(* com.example.aoptest..*(..))")
//    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
//
//        Object retVal = pjp.proceed(); // 메서드 호출 자체를 감쌈
//        log.info("PerfAspect use");
//        log.info("pjp 값 = {}", pjp.proceed());
//        log.info("retVal 값 = {}", retVal);
//        return retVal;
//
//    }

    @Around("@annotation(PerfLog)")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {

        Object retVal = pjp.proceed(); // 메서드 호출 자체를 감쌈
        log.info("PerfAspect use");
        log.info("pjp 값 = {}", pjp.proceed());
        log.info("retVal 값 = {}", retVal);


        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        PerfLog annotation = methodSignature.getMethod().getAnnotation(PerfLog.class);
        log.info("annotation 값 = {}", annotation);
        log.info("annotation.PageName() 값 = {}", annotation.PageName());
        log.info("annotation.ActionName() 값 = {}", annotation.ActionName());
        log.info("annotation.CRUDType() 값 = {}", annotation.CRUDType());

        return retVal;

    }
}
