package com.rodyapal.task15_postgres.model;

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

	public void saveAll(List<Student> students) {
		repository.saveAll(students);
	}

	public void delete(Student student) {
		repository.delete(student);
	}
}
