package com.rodyapal.task16_bindings.model.university;

import com.rodyapal.task16_bindings.model.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "universities")
public class University {
	@Id
	@SequenceGenerator(name = "university_sequence", sequenceName = "university_sequence", allocationSize = 1)
	@GeneratedValue(generator = "university_sequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String creationDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "university")
	private List<Student> students = new ArrayList<>();

	@Override
	public String toString() {
		return "University{" +
				"id=" + id +
				", name='" + name + '\'' +
				", creationDate='" + creationDate + '\'' +
				'}';
	}
}
