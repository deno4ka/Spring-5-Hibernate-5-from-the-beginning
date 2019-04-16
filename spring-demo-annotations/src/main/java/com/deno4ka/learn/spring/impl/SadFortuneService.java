package com.deno4ka.learn.spring.impl;

import com.deno4ka.learn.spring.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a sad day...";
	}

}
