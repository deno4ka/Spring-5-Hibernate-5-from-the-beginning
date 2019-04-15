package com.deno4ka.learn_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		com.deno4ka.learn_spring.impl.CricketCoach cricketCoach = context.getBean("myCricketCoach", com.deno4ka.learn_spring.impl.CricketCoach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		System.out.println(String.format("team: \"%s\", email: \"%s\"", cricketCoach.getTeam(), cricketCoach.getEmailAddress()));
		context.close();
	}

}
