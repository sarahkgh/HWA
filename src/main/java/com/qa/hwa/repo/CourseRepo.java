package com.qa.hwa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.hwa.domain.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

	@Query(value = "SELECT * FROM course WHERE courseName = ?1", nativeQuery = true)
	Optional<Course> findbyCourseName(String courseName);
}
