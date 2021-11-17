package com.qa.hwa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.Course;
import com.qa.hwa.service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {

	private CourseService service;

	public CourseController(CourseService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Course> create(@RequestBody Course course) {
		return new ResponseEntity<Course>(this.service.create(course), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Course>> getAll() {
		return new ResponseEntity<List<Course>>(this.service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/getById/{courseId}")
	public ResponseEntity<Course> getOne(@PathVariable int courseId) {
		return new ResponseEntity<Course>(this.service.getById(courseId), HttpStatus.OK);
	}

	@GetMapping("/getByCourseName/{courseName}")
	public ResponseEntity<Course> getByCourseName(@PathVariable String courseName) {
		return new ResponseEntity<Course>(this.service.getByCourseName(courseName), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{courseId}")
	public ResponseEntity<Course> update(@PathVariable int courseId, @RequestBody Course course) {
		return new ResponseEntity<Course>(this.service.update(courseId, course), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<Course> delete(@PathVariable int courseId) {
		return this.service.delete(courseId) ? new ResponseEntity<Course>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
