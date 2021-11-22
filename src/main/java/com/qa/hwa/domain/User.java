package com.qa.hwa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(nullable = false, unique = true)
	private String userName;
	
	public User() {
		super();
	}

	public User(String firstName, String userName) {
		this.firstName = firstName;
		this.userName = userName;
		

	}

	public User(long userId, String firstName, String userName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.userName = userName;
	}

	

}
