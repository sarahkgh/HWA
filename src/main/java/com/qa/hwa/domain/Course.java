package com.qa.hwa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;

	@Column(name = "courseName", nullable = false, unique = true)
	private String courseName;

	@Column(nullable = false)
	private String courseDescription;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, String courseDescription) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public Course(long courseId, String courseName, String courseDescription) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

}
