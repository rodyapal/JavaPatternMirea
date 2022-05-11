package com.example.task17_criteria_api.model.student;

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
public class StudentDAO {
	private final EntityManager entityManager;
	private final StudentRepository repository;

	@Autowired
	public StudentDAO(
			StudentRepository repository,
			EntityManager entityManager
	) {
		this.entityManager = entityManager;
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

	public List<Student> getByFirstName(String firstName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("firstName"), firstName);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<Student> getByLastName(String lastName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("lastName"), lastName);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<Student> getByMiddleName(String middleName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("middleName"), middleName);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<Student> getByUniversityName(Integer universityId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> studentRoot = criteriaQuery.from(Student.class);

		Predicate condition = builder.equal(studentRoot.get("universityId"), universityId);
		criteriaQuery.where(condition);

		TypedQuery<Student> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}