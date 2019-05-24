package com.deno4ka.learn.spring.aop.aspect.afterThrowingAdvice;

import com.deno4ka.learn.spring.aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoAfterThrowing {

	@Pointcut("execution(* com.deno4ka.learn.spring.aop.dao.AccountDAO.findAccounts(..))")
	public void findAccountsPointcut() {}

	@AfterThrowing(pointcut = "findAccountsPointcut()", throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint pointcut, Throwable theExc) {
		String methodName = pointcut.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterThrowing on method: " + methodName);
		System.out.println("=====>>> The Exception is: " + theExc + "\n");
	}

	@AfterReturning(pointcut = "findAccountsPointcut()", returning = "accountList")
	public void afterReturningFindAccountsAdvice (JoinPoint joinPoint, List<Account> accountList) {
		System.out.println("\n=====>>> Executing @AfterReturning advice on findAccounts()");
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + methodName);
		System.out.println("\n=====>>> result is: " + accountList);
//		if (!accountList.isEmpty()) {
//			accountList.get(0).setName("Duffy Duck");
//		}
		convertAccountNamesToUpperCase(accountList);
	}

	private void convertAccountNamesToUpperCase(List<Account> accountList) {
//		for (Account account: accountList) {
//			account.setName(account.getName().toUpperCase());
//		}
//		accountList.stream().forEach(u -> u.setName(u.getName().toUpperCase()));
		accountList.forEach(u -> u.setName(u.getName().toUpperCase()));
	}

}
