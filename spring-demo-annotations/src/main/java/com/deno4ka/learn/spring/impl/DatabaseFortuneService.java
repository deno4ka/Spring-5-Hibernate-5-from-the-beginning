package com.deno4ka.learn.spring.impl;

import com.deno4ka.learn.spring.interfaces.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return null;
	}

}
