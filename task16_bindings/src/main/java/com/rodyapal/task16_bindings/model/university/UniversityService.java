package com.rodyapal.task16_bindings.model.university;

import com.rodyapal.task16_bindings.model.student.Student;
import com.rodyapal.task16_bindings.model.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
	private final UniversityRepository repository;

	@Autowired
	public UniversityService(UniversityRepository repository) {
		this.repository = repository;
	}

	public List<University> getAll() {
		return (List<University>) repository.findAll();
	}

	public void save(University university) {
		repository.save(university);
	}

	public void delete(University university) {
		repository.delete(university);
	}
}
