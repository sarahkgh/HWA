package com.qa.hwa.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.hwa.domain.User;
import com.qa.hwa.repo.UserRepo;
//
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
//@DataJpaTest
public class UserServiceTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepo repo;

	@Test
	public void createTest() {
		User input = new User("Sarah", "SarahKC");
		User output = new User(1l, "Sarah", "SarahKC");

		Mockito.when(this.repo.save(input)).thenReturn(output);
//		System.out.println(this.service.create(input));
		assertEquals(output, this.service.create(input));
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
		
	}
	
	@Test
	public void getAllTest() {
		List<User> output = new ArrayList<>();
		output.add(new User("Sarah", "SarahKC"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();	}

}
