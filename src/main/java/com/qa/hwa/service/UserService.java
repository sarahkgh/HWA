package com.qa.hwa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.User;
import com.qa.hwa.repo.UserRepo;
import com.qa.hwa.exceptions.UserNameTakenException;
import com.qa.hwa.exceptions.UserNotFoundException;

@Service
public class UserService {

	private UserRepo repo;

	public UserService(UserRepo repo) {
		this.repo = repo;
	}

	public User create(User user) {
		return this.repo.save(user);
	}

	public List<User> getAll() {
		return this.repo.findAll();
	}

	public User getById(long userId) {
		return this.repo.findById(userId).orElseThrow(UserNotFoundException::new);
	}

	public User getByFirstName(String firstName) {
		return this.repo.findbyFirstName(firstName).get();
	}

	public User update(long userId, User user) {
		User existing = this.repo.findById(userId).get();
		existing.setFirstName(user.getFirstName());
		existing.setUserName(user.getUserName());
		return this.repo.saveAndFlush(existing);
	}

	public boolean delete(long userId) {
		this.repo.deleteById(userId);
		return this.repo.existsById(userId);
	}

	public User getByUsername(String username) {
		return this.repo.findbyUsername(username).orElseThrow(UserNameTakenException::new);
	}
}
