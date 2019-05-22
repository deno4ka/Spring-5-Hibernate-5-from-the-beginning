package com.deno4ka.learn.spring.aop.aspect.beforeAdvice;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoPointcutDeclarationsCombo {

	private static int executionCounter = 0;

//	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.*(..))") // for all methods in package
//	public void forDaoPackage() {}
//
//	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.get*(..))") // for all getter methods in package
//	public void getter() {}
//
//	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.set*(..))") // for all setter methods in package
//	public void setter() {}
//
//	@Pointcut("forDaoPackage() && !(getter() || setter())") // include all methods in package, exclude getters/setters
//	public void forDaoPackageNoGetterSetter() {}

//	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> #" + ++executionCounter +" Executing @Before advice on method()");
	}

}
