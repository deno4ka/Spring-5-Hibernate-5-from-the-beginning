package com.deno4ka.learn.spring.impl;

import com.deno4ka.learn.spring.interfaces.Coach;
import com.deno4ka.learn.spring.interfaces.FortuneService;

public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public BaseballCoach() {}

	@Override
	public String getDailyWorkout() {
		return "Spent 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
