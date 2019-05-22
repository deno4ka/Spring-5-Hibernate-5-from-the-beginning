package com.deno4ka.learn.spring.aop.aspect.orderingAspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.*(..))") // for all methods in package
	public void forDaoPackage() {}

	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.get*(..))") // for all getter methods in package
	public void getter() {}

	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.*.set*(..))") // for all setter methods in package
	public void setter() {}

	@Pointcut("forDaoPackage() && !(getter() || setter())") // include all methods in package, exclude getters/setters
	public void forDaoPackageNoGetterSetter() {}

}
