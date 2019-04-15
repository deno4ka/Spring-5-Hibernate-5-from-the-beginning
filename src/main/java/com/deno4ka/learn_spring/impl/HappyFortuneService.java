package com.deno4ka.learn_spring.impl;

import com.deno4ka.learn_spring.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
