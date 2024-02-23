package com.homework_mvc_thymeleaf.services.profession;

import com.homework_mvc_thymeleaf.model.Profession;
import com.homework_mvc_thymeleaf.services.DataService;

public interface ProfessionService extends DataService<Profession> {
    void update(Integer id, String name, String note);
}
