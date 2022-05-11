package com.rodyapal.task16_bindings.controller;

import com.rodyapal.task16_bindings.model.student.Student;
import com.rodyapal.task16_bindings.model.student.StudentService;
import com.rodyapal.task16_bindings.model.university.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String getStudents() {
		List<Student> students = studentService.getAll();
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append('\n');
		});
		return result.length() != 0 ? result.toString() : "No data";
	}

	@PostMapping("/students")
	public void addStudent(@RequestBody Student student) {
		studentService.save(student);
	}

	@DeleteMapping("/students")
	public void deleteStudent(@RequestBody Student student) {
		studentService.delete(student);
	}
}
