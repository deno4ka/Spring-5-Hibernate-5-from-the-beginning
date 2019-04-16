package com.deno4ka.learn.spring;

import com.deno4ka.learn.spring.impl.SadFortuneService;
import com.deno4ka.learn.spring.impl.SwimCoach;
import com.deno4ka.learn.spring.interfaces.Coach;
import com.deno4ka.learn.spring.interfaces.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.deno4ka.learn.spring")
public class SportConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
