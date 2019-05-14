package com.deno4ka.learn.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//	@Before("execution(public void addAccount())") // for any class
//	@Before("execution(public void add*())") // using wildcard for any class with method name starting with 'add'
//	@Before("execution(void add*())") // using wildcard for any class with method name starting with 'add'
	@Before("execution(boolean add*())") // using wildcard for any class with method name starting with 'add'
//	@Before("execution(* add*())") // using wildcard for any modifier/return type/class with method name starting with 'add'
//	@Before("execution(public void com.deno4ka.learn.spring.aop.dao.AccountDAO.addAccount())") // for specific class
//	@Before("execution(public void com.deno4ka.learn.spring.aop.dao.*DAO.addAccount())") // for specific class
//	@Before("execution(public void com.deno4ka.learn.spring.aop.dao.*.*())") // for specific class
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}

}
