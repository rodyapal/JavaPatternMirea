package com.rodyapal.task14_rest_basics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Task14ControllerOne {

	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
}