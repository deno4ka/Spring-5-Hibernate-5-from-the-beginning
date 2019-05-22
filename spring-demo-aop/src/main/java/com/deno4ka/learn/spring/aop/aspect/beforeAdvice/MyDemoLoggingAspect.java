package com.deno4ka.learn.spring.aop.aspect.beforeAdvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	private final String POINT_CUT = "execution(* com.deno4ka.learn.spring.aop.dao.*.*(..))";

//	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.*(..))")
//	public void myPointCut() {}

//	@Before("execution(public void addAccount())") // for any class
//	@Before("execution(public void add*())") // using wildcard for any class with method name starting with 'add'
//	@Before("execution(void add*())")
//	@Before("execution(boolean add*())")
//	@Before("execution(* add*())") // using wildcard for any modifier/return type/class with method name starting with 'add'
//	@Before("execution(* add*(com.deno4ka.learn.spring.aop.model.Account, boolean ))")
//	@Before("execution(* add*(com.deno4ka.learn.spring.aop.model.Account, ..))")
//	@Before("execution(* add*(..))") // any numbers of parameters from 0 to...
//	@Before("execution(public void com.deno4ka.learn.spring.aop.dao.AccountDAO.addAccount())") // for specific class
//	@Before("execution(public void com.deno4ka.learn.spring.aop.dao.AccountDAO.addAccount())") // for specific class
//	@Before("execution(public void com.deno4ka.learn.spring.aop.dao.*DAO.addAccount())")
//	@Before(POINT_CUT) // for all methods in package
//	@Before("myPointCut()") // for all methods in package
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}

//	@Before("com.deno4ka.learn.spring.aop.aspect.beforeAdvice.orderingAspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice (JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(arg);
		}
	}

}
