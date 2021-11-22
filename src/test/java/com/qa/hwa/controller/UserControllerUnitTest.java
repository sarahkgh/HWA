package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.qa.hwa.domain.User;
import com.qa.hwa.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private UserService service;

	@Test
	public void createTest() throws Exception {
		User user = new User(1l, "Sarah", "SarahKC");
		String userAsJSON = this.mapper.writeValueAsString(user);
		ResultMatcher checkstatus = status().isCreated();
		User userSaved = new User(1l, "Sarah", "SarahKC");
		String userSavedAsJSON = this.mapper.writeValueAsString(userSaved);

		RequestBuilder request = post("/user/create").contentType(MediaType.APPLICATION_JSON).content(userSavedAsJSON);

		ResultMatcher checkBody = content().json(userSavedAsJSON);

		Mockito.when(this.service.create(user)).thenReturn(user);

		this.mvc.perform(request).andExpect(checkstatus).andExpect(checkBody);
	}
	
	@Test
	void testReadAll() throws Exception {
		// Arrange
		User aUser = new User(2l,"John","Smith");
		List<User> users = new ArrayList<>();
		users.add(aUser);
		String aUserAsJSON = this.mapper.writeValueAsString(List.of(aUser));
		ResultMatcher checkstatus = status().isOk();
		
		// Act
		RequestBuilder request = get("/user/getAll");
		ResultMatcher checkBody = content().json(aUserAsJSON);
		
		// Assertion
		Mockito.when(this.service.getAll()).thenReturn(users);
		this.mvc.perform(request).andExpect(checkstatus).andExpect(checkBody);
	}
	
	@Test
	void testDelete() throws Exception {
		// Arrange
		Long userId = 1L;
		boolean del = true;
		ResultMatcher checkStatus = status().isNoContent();
		
		// Act
		RequestBuilder request = delete("/user/delete/1");
		
		//Assertion
		this.mvc.perform(request).andExpect(checkStatus);
		Mockito.when(this.service.delete(userId)).thenReturn(del);
	}
}
