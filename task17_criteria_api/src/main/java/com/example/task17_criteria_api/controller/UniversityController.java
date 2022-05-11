package com.example.task17_criteria_api.controller;


import com.example.task17_criteria_api.model.student.Student;
import com.example.task17_criteria_api.model.university.University;
import com.example.task17_criteria_api.model.university.UniversityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {

	private final UniversityDAO universityDAO;

	@Autowired
	public UniversityController(UniversityDAO universityDAO) {
		this.universityDAO = universityDAO;
	}

	@GetMapping("universities")
	public String getUniversities() {
		List<University> universities = universityDAO.getAll();
		StringBuilder result = new StringBuilder();
		universities.forEach((it) -> {
			result.append(it.toString()).append('\n');
		});
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/universities/name/{name}")
	public String getStudentsByFirstName(@PathVariable(name = "name") String name) {
		List<University> students = universityDAO.getByName(name);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append("\n");
		});
		System.out.println(result);
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/universities/date/{date}")
	public String getStudentsByLastName(@PathVariable(name = "date") String date) {
		List<University> students = universityDAO.getByDate(date);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append('\n');
		});
		return result.length() != 0 ? result.toString() : "No data";
	}

	@PostMapping("universities")
	public void addUniversity(@RequestBody University university) {
		universityDAO.save(university);
	}

	@DeleteMapping("universities")
	public void deleteUniversity(@RequestBody University university) {
		universityDAO.delete(university);
	}
}
