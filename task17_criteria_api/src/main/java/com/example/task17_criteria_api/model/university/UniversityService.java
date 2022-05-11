package com.example.task17_criteria_api.model.university;

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
public class UniversityService {
	private final EntityManager entityManager;
	private final UniversityRepository repository;

	@Autowired
	public UniversityService(UniversityRepository repository, EntityManager entityManager) {
		this.repository = repository;
		this.entityManager = entityManager;
	}

	public List<University> getAll() {
		log.info("All universities requested");
		return (List<University>) repository.findAll();
	}

	public void save(University university) {
		log.info("University saved: {}", university.toString());
		repository.save(university);
	}

	public void delete(University university) {
		log.info("University deleted: {}", university.toString());
		repository.delete(university);
	}

	public List<University> getByName(String name) {
		log.info("University requested by name: {}", name);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<University> criteriaQuery = builder.createQuery(University.class);
		Root<University> studentRoot = criteriaQuery.from(University.class);

		Predicate condition = builder.equal(studentRoot.get("name"), name);
		criteriaQuery.where(condition);

		TypedQuery<University> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public List<University> getByDate(String creationDate) {
		log.info("University requested by creation date: {}", creationDate);
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<University> criteriaQuery = builder.createQuery(University.class);
		Root<University> studentRoot = criteriaQuery.from(University.class);

		Predicate condition = builder.equal(studentRoot.get("creationDate"), creationDate);
		criteriaQuery.where(condition);

		TypedQuery<University> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}
