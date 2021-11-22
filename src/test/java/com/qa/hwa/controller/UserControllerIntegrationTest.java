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
import com.qa.hwa.domain.User;

import com.qa.hwa.service.UserService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:user-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:sql-schema.sql",
		"classpath:sql-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

@ActiveProfiles("test")
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;
	

	@Autowired
	UserService userService;



	@Test
	void createTest() throws Exception {
		User user = new User(1l, "Sarah", "SarahKC");
		String userAsJSON = this.mapper.writeValueAsString(user);

		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		User userSaved = new User(2l, "Josh", "JoshSmith");
		String userSavedAsJSON = this.mapper.writeValueAsString(userSaved);

		ResultMatcher checkStatus = status().isCreated();
		User userSaved = new User(2l, "Josh", "JoshSmith");
		String userSavedAsJSON = this.mapper.writeValueAsString(userSaved);
		
		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);


		ResultMatcher checkBody = content().json(userSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

}
	
	@Test
	void createTest2() throws Exception {
		User user = new User(1l, "Sarah", "SarahKC");
		String userAsJSON = this.mapper.writeValueAsString(user);
		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		User userSaved = new User(2l, "Josh", "JoshSmith");
		String userSavedAsJSON = this.mapper.writeValueAsString(userSaved);

		ResultMatcher checkBody = content().json(userSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

}
	@Test
	void testGet() throws Exception {
		User user = new User(1l, "Sarah","SarahKC");
		String userAsJSON = this.mapper.writeValueAsString(user);
		RequestBuilder request = get("user/getById/1").contentType(MediaType.APPLICATION_JSON);
		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(userAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetAll() throws Exception {
		User user = new User(1l, "Sarah", "SarahKC");
		String userAsJSON = this.mapper.writeValueAsString(List.of(user));

		RequestBuilder request = get("user/getAll").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);

		ResultMatcher checkStatus = status().isAccepted();


		ResultMatcher checkStatus = status().isOk();
		
		RequestBuilder request = get("user/getAll").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);


		ResultMatcher checkBody = content().json(userAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetByUsername() throws Exception {
		User sk = new User(1, "Sarah", "SarahKC");
		String skAsJSON = this.mapper.writeValueAsString(sk);
		RequestBuilder request = get("user/getByUsername/" + sk.getUserName());

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(skAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
	
	@Test
	void testGetByFirstName() throws Exception {
		User sk = new User(1, "Sarah", "SarahKC");
		String skAsJSON = this.mapper.writeValueAsString(sk);
		RequestBuilder request = get("user/getByFirstName/" + sk.getFirstName());

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(skAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
	
	@Test
	void testUpdate() throws Exception{
		User user = new User("Sarah", "SarahKC");
		String userAsJSON = this.mapper.writeValueAsString(user);

		RequestBuilder request = put("/user/update/1").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		

		ResultMatcher checkBody = content().json(userAsJSON);

		ResultMatcher checkStatus = status().isAccepted();
		
		User updatedUser = new User(1l, "Sarah", "SarahKCW");
		String updatedUserAsJSON = this.mapper.writeValueAsString(updatedUser);
		
		
		RequestBuilder request = put("/user/update/Sarah").contentType(MediaType.APPLICATION_JSON).content(userAsJSON);

		ResultMatcher checkBody = content().json(updatedUserAsJSON);


		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testDelete() throws Exception{

		RequestBuilder request = delete("/user/delete/1");
		ResultMatcher checkStatus = status().isNoContent();
		ResultMatcher checkStatus = status().isNoContent();
		RequestBuilder request = delete("/user/delete/1");
		
		this.mvc.perform(request).andExpect(checkStatus);
		
	}

}
