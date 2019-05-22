package com.deno4ka.learn.spring.aop.aspect.beforeAdvice.orderingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUndefined {

//	@Before("com.deno4ka.learn.spring.aop.aspect.before.orderingAspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing order UNDEFINED");
	}

}
