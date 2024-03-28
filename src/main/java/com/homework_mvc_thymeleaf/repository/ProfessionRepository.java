package com.homework_mvc_thymeleaf.repository;

import com.homework_mvc_thymeleaf.model.entities.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
    List<Profession> findAllByOrderById();
}
