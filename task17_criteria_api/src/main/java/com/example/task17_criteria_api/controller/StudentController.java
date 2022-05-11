package com.example.task17_criteria_api.controller;

import com.example.task17_criteria_api.model.entity.Student;
import com.example.task17_criteria_api.service.StudentService;
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
		for (Student student : students) {
			result.append(student).append("\n");
		}
		System.out.println(result);
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/students/firstName/{firstName}")
	public String getStudentsByFirstName(@PathVariable(name = "firstName") String firstName) {
		List<Student> students = studentService.getByFirstName(firstName);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> result.append(it.toString()).append("\n"));
		System.out.println(result);
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/students/lastName/{lastName}")
	public String getStudentsByLastName(@PathVariable(name = "lastName") String lastName) {
		List<Student> students = studentService.getByLastName(lastName);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> result.append(it.toString()).append('\n'));
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/students/middleName/{middleName}")
	public String getStudentsByMiddleName(@PathVariable(name = "middleName") String middleName) {
		List<Student> students = studentService.getByMiddleName(middleName);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> result.append(it.toString()).append('\n'));
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
