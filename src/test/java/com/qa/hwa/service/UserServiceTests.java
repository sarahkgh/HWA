package com.qa.hwa.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.qa.hwa.domain.User;
import com.qa.hwa.repo.UserRepo;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class UserServiceTests {

	@InjectMocks
	private UserService service;

	@Mock
	private UserRepo repo;

	@Test
	public void createTest() {
		User input = new User("Sarah", "SarahKC");
		User output = new User("Sarah", "SarahKC");

		Mockito.when(this.repo.save(input)).thenReturn(output);

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
