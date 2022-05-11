package com.example.task17_criteria_api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "universities")
public class University implements IEntity {
	@Id
	@SequenceGenerator(name = "university_sequence", sequenceName = "university_sequence", allocationSize = 1)
	@GeneratedValue(generator = "university_sequence", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	@Column(name = "creation_date")
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
