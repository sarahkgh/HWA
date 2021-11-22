package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.List;

import org.junit.jupiter.api.Test;
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


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:sql-schema.sql",
		"classpath:sql-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CourseControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	
	

	@Test
	void createTest() throws Exception {
		Course course = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		ResultMatcher checkStatus = status().isCreated();
		Course courseSaved = new Course(2l, "Time Management", "This course is all on time management for dummies!");
		String courseSavedAsJSON = this.mapper.writeValueAsString(courseSaved);
		
		RequestBuilder request = post("/course/create").contentType(MediaType.APPLICATION_JSON).content(courseAsJSON);		

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
		ResultMatcher checkStatus = status().isOk();
		
		RequestBuilder request = get("course/getAll").contentType(MediaType.APPLICATION_JSON).content(courseAsJSON);

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
		Course course = new Course("Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String courseAsJSON = this.mapper.writeValueAsString(course);
		ResultMatcher checkStatus = status().isAccepted();
		
		Course newCourse = new Course(1l,"Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String newCourseAsJSON = this.mapper.writeValueAsString(newCourse);
		RequestBuilder request = put("/course/update/Project Management").contentType(MediaType.APPLICATION_JSON).content(courseAsJSON);

		ResultMatcher checkBody = content().json(newCourseAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testDelete() throws Exception{
		ResultMatcher checkStatus = status().isNoContent();
		RequestBuilder request = delete("/course/delete/1");
		
		this.mvc.perform(request).andExpect(checkStatus);
		
	}

}
