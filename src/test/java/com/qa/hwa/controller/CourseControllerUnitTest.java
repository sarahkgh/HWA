package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.domain.Course;
import com.qa.hwa.domain.User;
import com.qa.hwa.service.CourseService;

@RunWith(SpringRunner.class)
@WebMvcTest
@SpringBootTest
public class CourseControllerUnitTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private CourseService service;
	
	@Test
	public void createTest() throws Exception {
		Course course = new Course(1l, "Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		ResultMatcher checkstatus = status().isCreated();
		Course courseSaved = new Course(1l, "Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseSavedAsJSON = this.mapper.writeValueAsString(courseSaved);

		RequestBuilder request = post("/course/create").contentType(MediaType.APPLICATION_JSON).content(courseSavedAsJSON);

		ResultMatcher checkBody = content().json(courseSavedAsJSON);

		Mockito.when(this.service.create(course)).thenReturn(course);

		this.mvc.perform(request).andExpect(checkstatus).andExpect(checkBody);
	}
	
	@Test
	void testReadAll() throws Exception {
		// Arrange
		Course aCourse = new Course(2l, "Time Management", "This course is all on time management for dummies!");
		List<Course> courses = new ArrayList<>();
		courses.add(aCourse);
		String aCourseAsJSON = this.mapper.writeValueAsString(List.of(aCourse));
		ResultMatcher checkstatus = status().isOk();
		
		// Act
		RequestBuilder request = get("/course/getAll");
		ResultMatcher checkBody = content().json(aCourseAsJSON);
		
		// Assertion
		Mockito.when(this.service.getAll()).thenReturn(courses);
		this.mvc.perform(request).andExpect(checkstatus).andExpect(checkBody);
	}
	
	@Test
	void testDelete() throws Exception {
		// Arrange
		Long courseId = 1L;
		boolean del = true;
		ResultMatcher checkStatus = status().isNoContent();
		
		// Act
		RequestBuilder request = delete("/course/delete/1");
		
		//Assertion
		this.mvc.perform(request).andExpect(checkStatus);
		Mockito.when(this.service.delete(courseId)).thenReturn(del);
	}
}
