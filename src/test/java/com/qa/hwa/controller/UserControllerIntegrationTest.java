package com.qa.hwa.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:user-schema.sql",
		"classpath:user-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void createTest() throws Exception {
		User me = new User("Sarah", "SarahKC");
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isCreated();

		User meSaved = new User(2l, "Sarah", "SarahKC");
		String meSavedAsJSON = this.mapper.writeValueAsString(me);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}
	
	@Test
	void testGet() throws Exception {
		User sk = new User(1, "Sarah","SarahKC");
		String jbAsJSON = this.mapper.writeValueAsString(sk);
		RequestBuilder request = get("user/getById/1");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(jbAsJSON);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetAll() throws Exception {
		User sk = new User(1, "Sarah", "SarahKC");
		String usersJSON = this.mapper.writeValueAsString(List.of(sk));
		RequestBuilder request = get("user/getAll");

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(usersJSON);
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
		User me = new User("Sarah", "SarahKC");
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = put("/user/create/1").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isAccepted();

		User meSaved = new User(1, "Sarah", "SarahKC");
		String meSavedAsJSON = this.mapper.writeValueAsString(me);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testDelete() throws Exception{
		this.mvc.perform(delete("/user/delete/1")).andExpect(status().isNoContent());
		
	}

}
