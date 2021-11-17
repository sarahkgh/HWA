package com.qa.hwa.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.ActiveProfiles;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:user-schema.sql", "classpath:user-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD) 
public class UserControllerTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
//	@Test
//	public void createTest() throws Exception{
//		User entry = new User("Sarah", "SarahKC");
//		User result = new User("Sarah", "SarahKC");
//		
//		String entryAsJSON = this.mapper.writeValueAsString(entry);
//		String resultAsJSON = this.mapper.writeValueAsString(result);
//		
//		mvc.perform(post("/user/create")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(entryAsJSON))
//				.andExpect(status().isCreated())
//				.andExpect(content().json(resultAsJSON));
//		}

}
