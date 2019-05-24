package com.deno4ka.learn.spring.aop;

import com.deno4ka.learn.spring.aop.dao.AccountDAO;
import com.deno4ka.learn.spring.aop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("AfterFinallyDemoApp ... caught  exception: " + e);
		}
		System.out.println("\n<<<<>>>> Printed from mainApp: accountList: " + accountList);
		context.close();
	}

}
