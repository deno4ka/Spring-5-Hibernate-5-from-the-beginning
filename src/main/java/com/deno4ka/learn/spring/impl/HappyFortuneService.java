package com.deno4ka.learn.spring.impl;

import com.deno4ka.learn.spring.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
