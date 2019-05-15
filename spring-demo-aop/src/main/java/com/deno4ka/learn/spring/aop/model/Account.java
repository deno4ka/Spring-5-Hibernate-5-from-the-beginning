package com.deno4ka.learn.spring.aop.model;

public class Account {

	private String name;
	private String level;

	public Account() {}

	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
