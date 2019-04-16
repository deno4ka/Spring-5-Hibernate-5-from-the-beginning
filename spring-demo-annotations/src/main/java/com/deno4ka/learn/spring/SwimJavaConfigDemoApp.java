package com.deno4ka.learn.spring;

import com.deno4ka.learn.spring.impl.SwimCoach;
import com.deno4ka.learn.spring.interfaces.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(String.format("email: %s\nteam: %s", theCoach.getEmail(), theCoach.getTeam()));
		context.close();
	}

}
