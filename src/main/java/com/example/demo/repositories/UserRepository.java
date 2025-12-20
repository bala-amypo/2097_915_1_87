package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Required by tests
    User findById(long id);

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
