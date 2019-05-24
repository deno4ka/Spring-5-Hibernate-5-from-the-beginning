package com.deno4ka.learn.spring.aop.aspect.aroundAdvice;

import com.deno4ka.learn.spring.aop.AroundWithLoggerDemoApp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoAroundWithLogger {

	private static Logger myLogger = Logger.getLogger(MyDemoAroundWithLogger.class.getName());

	@Pointcut("execution(* com.deno4ka.learn.spring.aop.service.*.getFortune(..))")
	public void getFortunePointcut() {}

//	@Around("getFortunePointcut()")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String methodName = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on method: " + methodName);
		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("=====> Duration: " + duration / 1000.0 + " seconds\n");
		return result;
	}

}
