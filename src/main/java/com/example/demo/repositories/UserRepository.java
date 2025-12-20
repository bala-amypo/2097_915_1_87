package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by email (used in authentication)
    Optional<User> findByEmail(String email);

    // Check if a user exists by email (used in UserServiceImpl.registerUser)
    boolean existsByEmail(String email);
}
