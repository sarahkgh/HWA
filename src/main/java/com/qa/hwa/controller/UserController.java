package com.qa.hwa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.User;
import com.qa.hwa.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		return new ResponseEntity<User>(this.service.create(user), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(this.service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/getById/{userId}")
	public ResponseEntity<User> getOne(@PathVariable int userId) {
		return new ResponseEntity<User>(this.service.getById(userId), HttpStatus.OK);
	}

	@GetMapping("/getByUsername/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String userName) {
		return new ResponseEntity<User>(this.service.getByUsername(userName), HttpStatus.ACCEPTED);
	}

	@GetMapping("/getByFirstName/{firstName}")
	public ResponseEntity<User> getByFirstName(@PathVariable String firstName) {
		return new ResponseEntity<User>(this.service.getByFirstName(firstName), HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<User> update(@PathVariable int userId, @RequestBody User user) {
		return new ResponseEntity<User>(this.service.update(userId, user), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<User> delete(@PathVariable int userId) {
		return this.service.delete(userId) ? new ResponseEntity<User>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
