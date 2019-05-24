package com.deno4ka.learn.spring.aop.aspect.aroundAdvice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoAroundHandleException {

	private static Logger myLogger = Logger.getLogger(MyDemoAroundHandleException.class.getName());

	@Pointcut("execution(* com.deno4ka.learn.spring.aop.service.*.getFortune(..))")
	public void getFortunePointcut() {}

//	@Around("getFortunePointcut()")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String methodName = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on method: " + methodName);
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			result = "Major accident! But not worries, your private AOP helicopter is on the way";
		}
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("=====> Duration: " + duration / 1000.0 + " seconds\n");
		return result;
	}

}
