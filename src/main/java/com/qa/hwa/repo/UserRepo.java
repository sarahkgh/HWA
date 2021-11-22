package com.qa.hwa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.hwa.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM user WHERE userName = ?1", nativeQuery = true)
	Optional<User> findbyUsername(String userName);

	@Query(value = "SELECT * FROM user WHERE firstName = ?1", nativeQuery = true)
	Optional<User> findbyFirstName(String firstName);

	@Query(value = "SELECT * FROM user WHERE userId = ?1", nativeQuery = true)
	Optional<User> findById(int userId);

	@Query(value = "DELETE * FROM user WHERE userId = ?1", nativeQuery = true)
	Optional<User> deleteById(int userId);

	

}
