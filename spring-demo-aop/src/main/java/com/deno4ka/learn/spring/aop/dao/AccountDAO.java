package com.deno4ka.learn.spring.aop.dao;

import com.deno4ka.learn.spring.aop.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public List<Account> findAccounts() {
		List<Account> accountList = new ArrayList<>();
		accountList.add(new Account("John", "Silver"));
		accountList.add(new Account("Luca", "Gold"));
		accountList.add(new Account("Madhu", "Platinum"));
		return accountList;
	}

	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		return true;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
