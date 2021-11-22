package com.qa.hwa.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		User user = new User(1l, "Sarah", "SarahKC");
		User input = new User("Sarah", "SarahKC");
		User output = new User(1l, "Sarah", "SarahKC");

		Mockito.when(this.repo.save(input)).thenReturn(output);
//		System.out.println(this.service.create(input));
		assertEquals(output, this.service.create(input));
		Mockito.verify(this.repo, Mockito.times(1)).save(input);

	}

	@Test
	public void getAllTest() {
		User user = new User(1l, "Sarah", "SarahKC");
		List<User> output = new ArrayList<>();
		output.add(new User("Sarah", "SarahKC"));

		Mockito.when(this.repo.findAll()).thenReturn(output);
		assertEquals(output, this.service.getAll());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void getOneTest() {
		Long userId = 1L;
		User user = new User(1l, "Sarah", "SarahKC");
		User output = new User(1l, "Sarah", "SarahKC");

		Mockito.when(this.repo.findById(userId)).thenReturn(Optional.of(output));

		assertEquals(output, this.service.getById(userId));
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);

	}
	
	@Test
	public void updateTest() {
		Long userId = 1L;
		User oldUser = new User(2l, "Josh", "JoshSmith");
		User newUser = new User(3l, "Jamie", "JamieOliver");
		
		Mockito.when(this.repo.findById(userId)).thenReturn(Optional.of(oldUser));
		Mockito.when(this.repo.saveAndFlush(oldUser)).thenReturn(newUser);
		
	assertEquals(oldUser, this.service.update(userId, newUser));
	Mockito.verify(this.repo, Mockito.times(1)).findById(userId);
	Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(oldUser);
	
	}
	
	@Test
	public void deleteTest() {
		Long userId = 1l;
		boolean deleted = true;
		
		Mockito.when(this.service.delete(userId)).thenReturn(deleted);
		assertEquals(deleted, this.repo.existsById(userId));
	}
}
