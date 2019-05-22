package com.deno4ka.learn.spring.aop.aspect.orderingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class AspectTwo {

//	@Before("com.deno4ka.learn.spring.aop.aspect.orderingAspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing order 2 TWO");
	}

}
