package com.deno4ka.learn.spring;

import com.deno4ka.learn.spring.impl.TrackCoach;
import com.deno4ka.learn.spring.interfaces.Coach;

public class MyApp {

	public static void main(String[] args) {
//		com.deno4ka.learn_spring.interfaces.Coach theCoach = new com.deno4ka.learn_spring.impl.BaseballCoach();
		Coach theCoach = new TrackCoach();
		System.out.println(theCoach.getDailyWorkout());
	}

}
