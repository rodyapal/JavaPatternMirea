package com.example.task17_criteria_api.model.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@Slf4j
public class StudentService {
	private final EntityManager entityManager;
	private final StudentRepository repository;

	@Autowired
	public StudentService(
			StudentRepository repository,
			EntityManager entityManager
	) {
		this.entityManager = entityManager;
		this.repository = repository;
	}

	public List<Student> getAll() {
		log.info("All students requested");
		return (List<Student>) repository.findAll();
	}

	public void save(Student student) {
		log.info("Student saved: {}", student.toString());
		repository.save(student);
	}

	public void delete(Student student) {
		log.info("Student deleted: {}", student.toString());
		repository.delete(student);
	}

	public List<Student> getByFirstName(String firstName) {
		log.info("Student requested by first name: {}", firstName);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("firstName"), firstName);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<Student> getByLastName(String lastName) {
		log.info("Student requested by last name: {}", lastName);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("lastName"), lastName);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<Student> getByMiddleName(String middleName) {
		log.info("Student requested by middle name: {}", middleName);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("middleName"), middleName);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<Student> getByUniversityName(Integer universityId) {
		log.info("Student requested by university id: {}", universityId);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("universityId"), universityId);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}