package com.example.task17_criteria_api.controller;

import com.example.task17_criteria_api.model.student.Student;
import com.example.task17_criteria_api.model.student.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
	private final StudentDAO studentDAO;

	@Autowired
	public StudentController(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@GetMapping("/students")
	public String getStudents() {
		List<Student> students = studentDAO.getAll();
		StringBuilder result = new StringBuilder();
		for (Student student : students) {
			result.append(student).append("\n");
		}
		System.out.println(result);
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/students/firstName/{firstName}")
	public String getStudentsByFirstName(@PathVariable(name = "firstName") String firstName) {
		List<Student> students = studentDAO.getByFirstName(firstName);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append("\n");
		});
		System.out.println(result);
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/students/lastName/{lastName}")
	public String getStudentsByLastName(@PathVariable(name = "lastName") String lastName) {
		List<Student> students = studentDAO.getByLastName(lastName);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append('\n');
		});
		return result.length() != 0 ? result.toString() : "No data";
	}

	@GetMapping("/students/middleName/{middleName}")
	public String getStudentsByMiddleName(@PathVariable(name = "middleName") String middleName) {
		List<Student> students = studentDAO.getByMiddleName(middleName);
		StringBuilder result = new StringBuilder();
		students.forEach((it) -> {
			result.append(it.toString()).append('\n');
		});
		return result.length() != 0 ? result.toString() : "No data";
	}

	@PostMapping("/students")
	public void addStudent(@RequestBody Student student) {
		studentDAO.save(student);
	}

	@DeleteMapping("/students")
	public void deleteStudent(@RequestBody Student student) {
		studentDAO.delete(student);
	}
}
