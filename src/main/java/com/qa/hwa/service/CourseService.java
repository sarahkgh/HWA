package com.qa.hwa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Course;
import com.qa.hwa.exceptions.CourseNameTakenException;
import com.qa.hwa.exceptions.CourseNotFoundException;
import com.qa.hwa.repo.CourseRepo;

@Service
public class CourseService {
	
	private CourseRepo repo;
	
	public CourseService(CourseRepo repo) {
		this.repo = repo;
	}
	
	public Course create(Course course) {
		return this.repo.saveAndFlush(course);
	}


	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
		}

	
	public Course getById(long courseId) {
		// TODO Auto-generated method stub
		return this.repo.findById(courseId).orElseThrow(CourseNotFoundException::new);
	}

	
	public Course getByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return this.repo.findbyCourseName(courseName).orElseThrow(CourseNameTakenException::new);
	}

	
	public Course update(long courseId, Course course) {
		// TODO Auto-generated method stub
		Course existing = this.repo.findById(courseId).get();
		existing.setCourseName(course.getCourseName());
		existing.setCourseDescription(course.getCourseDescription());
		return this.repo.saveAndFlush(existing);
	}

	
	public boolean delete(long courseId) {
		// TODO Auto-generated method stub
		this.repo.deleteById(courseId);
		return !this.repo.existsById(courseId);
	}

}
