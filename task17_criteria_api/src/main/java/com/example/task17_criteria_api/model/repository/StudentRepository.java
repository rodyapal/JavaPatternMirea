package com.example.task17_criteria_api.model.repository;

import com.example.task17_criteria_api.model.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}