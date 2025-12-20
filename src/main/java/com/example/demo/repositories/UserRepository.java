package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // Make sure it returns Optional<User>
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email); // if test uses email
}
