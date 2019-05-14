package com.deno4ka.learn.spring.aop;

import com.deno4ka.learn.spring.aop.dao.AccountDAO;
import com.deno4ka.learn.spring.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		accountDAO.addAccount();
//		System.out.println("\n let's call it again!\n");
//		accountDAO.addAccount();
		membershipDAO.addSillyMember();
		context.close();
	}

}
