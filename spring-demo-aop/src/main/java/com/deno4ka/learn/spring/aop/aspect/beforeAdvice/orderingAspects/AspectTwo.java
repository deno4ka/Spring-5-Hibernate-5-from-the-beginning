package com.deno4ka.learn.spring.aop.aspect.beforeAdvice.orderingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class AspectTwo {

//	@Before("com.deno4ka.learn.spring.aop.aspect.before.orderingAspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing order 2 TWO");
	}

}
