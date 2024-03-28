package com.homework_mvc_thymeleaf.services.profession;

import com.homework_mvc_thymeleaf.model.entities.Profession;
import com.homework_mvc_thymeleaf.services.DataService;

import java.util.List;

public interface ProfessionService extends DataService<Profession> {
    List<Profession> getAllOrderById();

    void update(Profession profession);
}
