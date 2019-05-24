package com.deno4ka.learn.spring.aop;

import com.deno4ka.learn.spring.aop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("Main Program: AroundWithLoggerDemoApp");
		myLogger.info("Calling getFortune");
		myLogger.info("My fortune is: " + trafficFortuneService.getFortune());
		myLogger.info("Finished");
		context.close();
	}

}
