package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.domain.Course;
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
	public void createTest() throws Exception{
		Course entry = new Course("Project Management", "This course is all the basics of project management. Beginner to Professional!");
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/course/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(entryAsJSON));
	}
}
