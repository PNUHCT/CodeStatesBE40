package com.codestates.cmarket.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

  @Around("execution(* com.example.codemarket..*(..))")
  public Object callTimeTrace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    String name = proceedingJoinPoint.toShortString();
    try {
      return proceedingJoinPoint.proceed();
    } catch (Exception e) {
      return e;
    } finally {
      long endTime = System.currentTimeMillis();
      long callTime = endTime - startTime;
      System.out.println(name + " = " +callTime);
    }
  }
}
