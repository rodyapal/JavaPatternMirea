package com.example.task17_criteria_api.model.repository;

import com.example.task17_criteria_api.model.entity.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long> {
}