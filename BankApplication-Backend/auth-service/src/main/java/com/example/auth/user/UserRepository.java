package com.example.auth.user;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(String email);  // must match exactly
	 boolean existsByEmail(String email);
}
