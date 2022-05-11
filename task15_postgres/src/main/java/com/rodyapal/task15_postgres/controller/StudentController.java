package com.rodyapal.task15_postgres.controller;

import com.rodyapal.task15_postgres.model.Student;
import com.rodyapal.task15_postgres.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

	private final StudentService service;

	@Autowired
	public StudentController(StudentService service) {
		this.service = service;
	}

	@GetMapping("/students")
	public String get() {
		List<Student> students = service.getAll();
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append("\n");
		});
		return result.length() != 0 ? result.toString() : "No data";
	}

	@PostMapping("/students")
	public void add(@RequestBody Student student) {
		service.save(student);
	}

	@PostMapping("/studentsAll")
	public void addAll(@RequestBody List<Student> students) {
		service.saveAll(students);
	}

	@DeleteMapping("/students")
	public void delete(@RequestBody Student student) {
		service.delete(student);
	}
}
