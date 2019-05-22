package com.deno4ka.learn.spring.aop.aspect.beforeAdvice.orderingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class AspectFirst {

//	@Before("com.deno4ka.learn.spring.aop.aspect.before.orderingAspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing order 1 FIRST");
	}

}
