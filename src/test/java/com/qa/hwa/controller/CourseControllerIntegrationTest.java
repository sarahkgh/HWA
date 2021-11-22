package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.domain.Course;
import com.qa.hwa.service.CourseService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:course-schema.sql",
		"classpath:course-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CourseControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	CourseService courseService;

	@Test
	void createTest() throws Exception {
		Course course = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		RequestBuilder request = post("/course/create").contentType(MediaType.APPLICATION_JSON).content(courseAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		Course courseSaved = new Course(2l, "Time Management", "This course is all on time management for dummies!");
		String courseSavedAsJSON = this.mapper.writeValueAsString(courseSaved);

		ResultMatcher checkBody = content().json(courseSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

}
	
	@Test
	void createTest2() throws Exception {
		Course course = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		RequestBuilder request = post("/course/create").contentType(MediaType.APPLICATION_JSON).content(courseAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		Course courseSaved = new Course(2l, "Time Management", "This course is all on time management for dummies!");
		String courseSavedAsJSON = this.mapper.writeValueAsString(courseSaved);

		ResultMatcher checkBody = content().json(courseSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

}
	@Test
	void testGet() throws Exception {
		Course course = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		RequestBuilder request = get("course/getById/1").contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(courseAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetAll() throws Exception {
		Course course = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(List.of(course));
		RequestBuilder request = get("course/getAll").contentType(MediaType.APPLICATION_JSON).content(courseAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(courseAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetByCourseName() throws Exception {
		Course course = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		RequestBuilder request = get("user/getByUserName/" + course.getCourseName());

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(courseAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
	

	
	@Test
	void testUpdate() throws Exception{
		Course course = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		RequestBuilder request = put("/course/update/1").contentType(MediaType.APPLICATION_JSON).content(courseAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		

		ResultMatcher checkBody = content().json(courseAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testDelete() throws Exception{
		RequestBuilder request = delete("/course/delete/1");
		ResultMatcher checkStatus = status().isNoContent();
		this.mvc.perform(request).andExpect(checkStatus);
		
	}

}

