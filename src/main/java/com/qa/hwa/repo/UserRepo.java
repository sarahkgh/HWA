package com.qa.hwa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.hwa.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM user WHERE userName = ?1", nativeQuery = true)
	Optional<User> findbyUsername(String userName);

	@Query(value = "SELECT * FROM user WHERE firstJame = ?1", nativeQuery = true)
	Optional<User> findbyFirstName(String firstName);

}
