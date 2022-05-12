package com.example.task17_criteria_api.service;

import com.example.task17_criteria_api.model.entity.University;
import com.example.task17_criteria_api.model.repository.UniversityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class UniversityService {
	private final EntityManager entityManager;
	private final UniversityRepository repository;
	private final EmailService emailService;

	@Autowired
	public UniversityService(
			UniversityRepository repository,
			EntityManager entityManager,
			EmailService emailService
	) {
		this.repository = repository;
		this.entityManager = entityManager;
		this.emailService = emailService;
	}

	@Transactional
	public List<University> getAll() {
		log.info("All universities requested");
		return (List<University>) repository.findAll();
	}

	@Transactional
	public void save(University university) {
		log.info("University saved: {}", university.toString());
		emailService.sendNotification(university);
		repository.save(university);
	}

	@Transactional
	public void delete(University university) {
		log.info("University deleted: {}", university.toString());
		repository.delete(university);
	}

	@Transactional
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

	@Transactional
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
