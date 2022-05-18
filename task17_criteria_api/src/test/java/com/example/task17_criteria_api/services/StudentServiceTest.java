package com.example.task17_criteria_api.services;

import com.example.task17_criteria_api.model.entity.Student;
import com.example.task17_criteria_api.model.repository.StudentRepository;
import com.example.task17_criteria_api.service.EmailService;
import com.example.task17_criteria_api.service.StudentService;
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
public class StudentServiceTest {
	@Mock private EntityManager entityManager;
	@Mock private StudentRepository repository;
	@Mock private EmailService emailService;

	private StudentService studentService;

	@BeforeEach
	void setUp() {
		this.studentService = new StudentService(repository, entityManager, emailService);
	}

	@Test
	void testGetStudents() {
		List<Student> students = List.of(
				new Student("TestFirstName1", "TestLastName1", "TestMiddleName1", -1L, null, -1L),
				new Student("TestFirstName2", "TestLastName2", "TestMiddleName2", -2L, null, -1L)
		);
		Mockito.when(repository.findAll()).thenReturn(students);
		List<Student> testResult = studentService.getAll();
		Assertions.assertEquals(students, testResult);
		Assertions.assertEquals(students.size(), testResult.size());
		Assertions.assertEquals(students.get(0).getId(), testResult.get(0).getId());
	}

	@Test
	void testSave() {
		Student student = new Student("TestFirstName1", "TestLastName1", "TestMiddleName1", -1L, null, -1L);
		studentService.save(student);
		Mockito.verify(repository).save(student);
	}

	@Test
	void testDelete() {
		Student student = new Student("TestFirstName1", "TestLastName1", "TestMiddleName1", -1L, null, -1L);
		studentService.delete(student);
		Mockito.verify(repository).delete(student);
	}
}
