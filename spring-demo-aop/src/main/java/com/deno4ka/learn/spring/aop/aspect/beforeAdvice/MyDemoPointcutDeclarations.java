package com.deno4ka.learn.spring.aop.aspect.beforeAdvice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoPointcutDeclarations {

//	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.*(..))") // for all methods in package
//	public void forDaoPackage() {}

//	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing @Before advice on method()");
	}

//	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");
	}

}
