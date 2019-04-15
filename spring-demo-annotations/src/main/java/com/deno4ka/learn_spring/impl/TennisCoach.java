package com.deno4ka.learn_spring.impl;

import com.deno4ka.learn_spring.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
