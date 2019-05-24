package com.deno4ka.learn.spring.aop;

import com.deno4ka.learn.spring.aop.dao.AccountDAO;
import com.deno4ka.learn.spring.aop.dao.MembershipDAO;
import com.deno4ka.learn.spring.aop.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
//		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
//		accountDAO.addAccount(new Account("admin", "system"), true);
//		accountDAO.doWork();
//		accountDAO.setName("foobar");
//		accountDAO.setServiceCode("silver");
//		accountDAO.getName();
//		accountDAO.getServiceCode();
//		System.out.println("\n let's call it again!\n");
//		accountDAO.addAccount();
//		membershipDAO.addSillyMember();
//		membershipDAO.goToSleep();
		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("mainApp ... caught  exception: " + e);
		}
		System.out.println("\n<<<<>>>> Printed from mainApp: accountList: " + accountList);
		context.close();
	}

}
