package com.example.task17_criteria_api.services;

import com.example.task17_criteria_api.model.entity.Student;
import com.example.task17_criteria_api.model.entity.University;
import com.example.task17_criteria_api.model.repository.UniversityRepository;
import com.example.task17_criteria_api.service.EmailService;
import com.example.task17_criteria_api.service.StudentService;
import com.example.task17_criteria_api.service.UniversityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UniversityServiceTest {
	@Mock
	private EntityManager entityManager;
	@Mock private UniversityRepository repository;
	@Mock private EmailService emailService;

	private UniversityService universityService;

	@BeforeEach
	void setUp() {
		this.universityService = new UniversityService(repository, entityManager, emailService);
	}

	@Test
	void testGetStudents() {
		List<University> universities = List.of(
				new University(-1L, "TestName1", "TestDate1", null),
				new University(-2L, "TestName1", "TestDate1", null)
		);
		Mockito.when(repository.findAll()).thenReturn(universities);
		List<University> testResult = universityService.getAll();
		Assertions.assertEquals(universities, testResult);
		Assertions.assertEquals(universities.size(), testResult.size());
		Assertions.assertEquals(universities.get(0).getId(), testResult.get(0).getId());
	}

	@Test
	void testSave() {
		University university = new University(-2L, "TestName1", "TestDate1", null);
		universityService.save(university);
		Mockito.verify(repository).save(university);
	}

	@Test
	void testDelete() {
		University university = new University(-2L, "TestName1", "TestDate1", null);
		universityService.delete(university);
		Mockito.verify(repository).delete(university);
	}
}
