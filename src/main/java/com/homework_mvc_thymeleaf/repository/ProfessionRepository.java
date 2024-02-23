package com.homework_mvc_thymeleaf.repository;

import com.homework_mvc_thymeleaf.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {
}
