package com.homework_mvc_thymeleaf.services.profession;

import com.homework_mvc_thymeleaf.model.Profession;
import com.homework_mvc_thymeleaf.repository.ProfessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {
    private ProfessionRepository professionRepository;

    @Override
    public List<Profession> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public Profession get(Integer id) {
        return professionRepository.findById(id).orElse(null);
    }

    @Override
    public Profession save(Profession profession) {
        return professionRepository.save(profession);
    }

    @Override
    public void update(Integer id, String name, String note) {
        Optional<Profession> professionOptional = professionRepository.findById(id);
        if (professionOptional.isPresent()) {
            Profession profession = professionOptional.get();
            profession.setName(name);
            profession.setNote(note);
            professionRepository.save(profession);
        }
    }
    @Override
    public void delete(Integer id) {
         professionRepository.deleteById(id);
    }
}
