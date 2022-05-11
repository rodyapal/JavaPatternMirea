package com.example.task17_criteria_api.controller;


import com.example.task17_criteria_api.model.university.University;
import com.example.task17_criteria_api.model.university.UniversityService;
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

	@GetMapping("/universities/name/{name}")
	public String getStudentsByFirstName(@PathVariable(name = "name") String name) {
		List<University> students = universityService.getByName(name);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append("\n");
		});
		System.out.println(result);
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/universities/date/{date}")
	public String getStudentsByLastName(@PathVariable(name = "date") String date) {
		List<University> students = universityService.getByDate(date);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
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
