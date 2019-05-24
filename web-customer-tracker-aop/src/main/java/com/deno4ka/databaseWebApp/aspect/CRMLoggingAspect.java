package com.deno4ka.databaseWebApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

	@Pointcut("execution(* com.deno4ka.databaseWebApp.controller.*.*(..))")
	public void controller() {}

	@Pointcut("execution(* com.deno4ka.databaseWebApp.service.*.*(..))")
	public void service() {}

	@Pointcut("execution(* com.deno4ka.databaseWebApp.dao.*.*(..))")
	public void dao() {}

	@Pointcut("controller() || service() || dao()")
	public void controllerServiceDao() {}

	@Before("controllerServiceDao()")
	public void loggingBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @Before: calling method: " + methodName);

		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			logger.info("=====>> argument: " + arg);
		}
	}

	@AfterReturning(pointcut = "controllerServiceDao()", returning = "result")
	public void loggingAfter(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();
		logger.info("=====>> in @AfterReturning: calling method: " + methodName);

		logger.info("=====>> result: " + result);
	}

}
