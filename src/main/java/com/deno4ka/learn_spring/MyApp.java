package com.deno4ka.learn_spring;

import com.deno4ka.learn_spring.impl.TrackCoach;
import com.deno4ka.learn_spring.interfaces.Coach;

public class MyApp {

	public static void main(String[] args) {
//		com.deno4ka.learn_spring.interfaces.Coach theCoach = new com.deno4ka.learn_spring.impl.BaseballCoach();
		Coach theCoach = new TrackCoach();
		System.out.println(theCoach.getDailyWorkout());
	}

}
