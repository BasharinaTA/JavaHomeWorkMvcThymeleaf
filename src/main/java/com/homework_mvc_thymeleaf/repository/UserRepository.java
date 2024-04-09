package com.homework_mvc_thymeleaf.repository;

import com.homework_mvc_thymeleaf.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
