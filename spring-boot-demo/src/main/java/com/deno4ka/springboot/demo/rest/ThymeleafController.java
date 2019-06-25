package com.deno4ka.springboot.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class ThymeleafController {

	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("date", new Date());
		return "helloworld";
	}

}
