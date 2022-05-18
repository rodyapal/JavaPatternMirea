package com.example.task17_criteria_api.controller;

import com.example.task17_criteria_api.model.entity.User;
import com.example.task17_criteria_api.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AuthController {
	private final UserAuthService userAuthService;

	@Autowired
	public AuthController(UserAuthService userAuthService) {
		this.userAuthService = userAuthService;
	}

	@GetMapping("login")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping("")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("registration")
	public String getRegistrationPage(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("user", user);
		return "registration";
	}

	@PostMapping("registration")
	public String signUpUser(@ModelAttribute("user") User user) {
		userAuthService.signUpUser(user);
		return "index";
	}
}