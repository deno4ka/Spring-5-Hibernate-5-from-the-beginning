package com.deno4ka.learn.spring.aop.aspect.orderingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUndefine {

//	@Before("com.deno4ka.learn.spring.aop.aspect.orderingAspects.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice () {
		System.out.println("\n=====>>> Executing order UNDEFINE");
	}

}
