package com.rodyapal.task14_rest_basics.controllers;

import com.rodyapal.task14_rest_basics.model.University;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class UniversityController {
	private University university;

	@GetMapping("/university")
	public String get() {
		if (university != null) {
			return university.toString();
		}
		return "Null university";
	}

	@PostMapping("/university")
	public void post(@RequestBody University university) {
		this.university = university;
	}

	@DeleteMapping("/university")
	public void delete() {
		this.university = null;
	}
}
