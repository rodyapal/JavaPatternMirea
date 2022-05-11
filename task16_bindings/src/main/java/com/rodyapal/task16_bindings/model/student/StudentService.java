package com.rodyapal.task16_bindings.model.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
	private final StudentRepository repository;

	@Autowired
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public List<Student> getAll() {
		return (List<Student>) repository.findAll();
	}

	public void save(Student student) {
		repository.save(student);
	}

	public void delete(Student student) {
		repository.delete(student);
	}
}