package com.rodyapal.task16_bindings.controller;

import com.rodyapal.task16_bindings.model.university.University;
import com.rodyapal.task16_bindings.model.university.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {

	private final UniversityService universityService;

	@Autowired
	public UniversityController(UniversityService universityService) {
		this.universityService = universityService;
	}

	@GetMapping("universities")
	public String getUniversities() {
		List<University> universities = universityService.getAll();
		StringBuilder result = new StringBuilder();
		universities.forEach((it) -> {
			result.append(it.toString()).append('\n');
		});
		return result.length() != 0 ? result.toString() : "No data";
	}

	@PostMapping("universities")
	public void addUniversity(@RequestBody University university) {
		universityService.save(university);
	}

	@DeleteMapping("universities")
	public void deleteUniversity(@RequestBody University university) {
		universityService.delete(university);
	}
}
