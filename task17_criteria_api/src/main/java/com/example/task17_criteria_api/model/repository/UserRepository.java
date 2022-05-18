package com.example.task17_criteria_api.model.repository;

import com.example.task17_criteria_api.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}