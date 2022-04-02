package com.rodyapal.task14_rest_basics.controllers;

import com.rodyapal.task14_rest_basics.model.Student;
import com.rodyapal.task14_rest_basics.model.University;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
	private Student student;

	@GetMapping("/student")
	public String get() {
		if (student != null) {
			return student.toString();
		}
		return "Null student";
	}

	@PostMapping("/student")
	public void post(@RequestBody Student student) {
		this.student = student;
	}

	@DeleteMapping("/student")
	public void delete() {
		this.student = null;
	}
}
