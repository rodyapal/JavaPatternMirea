package com.rodyapal.task15_postgres.repository;

import com.rodyapal.task15_postgres.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}