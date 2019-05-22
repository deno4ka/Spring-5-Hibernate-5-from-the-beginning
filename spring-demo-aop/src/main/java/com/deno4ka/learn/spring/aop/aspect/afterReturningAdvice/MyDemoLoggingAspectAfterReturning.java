package com.deno4ka.learn.spring.aop.aspect.afterReturningAdvice;

import com.deno4ka.learn.spring.aop.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspectAfterReturning {

	@AfterReturning(
			pointcut = "execution(* com.deno4ka.learn.spring.aop.dao.AccountDAO.findAccounts(..))",
			returning = "accountList")
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
