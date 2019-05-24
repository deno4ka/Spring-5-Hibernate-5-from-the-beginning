package com.deno4ka.learn.spring.aop;

import com.deno4ka.learn.spring.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("Main Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		System.out.println("My fortune is: " + trafficFortuneService.getFortune());
		System.out.println("Finished");
		context.close();
	}

}
