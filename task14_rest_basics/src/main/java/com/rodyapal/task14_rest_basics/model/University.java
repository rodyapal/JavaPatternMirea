package com.rodyapal.task14_rest_basics.model;

public class University {
	private String name;
	private String creationDate;

	public University(String name, String creationDate) {
		this.name = name;
		this.creationDate = creationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "University{" +
				"name='" + name + '\'' +
				", creationDate='" + creationDate + '\'' +
				'}';
	}
}
