package com.homework_mvc_thymeleaf.services.profession;

import com.homework_mvc_thymeleaf.model.entities.Profession;
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
    public List<Profession> getAllOrderById() {
        return professionRepository.findAllByOrderById();
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
    public void update(Profession profession) {
        Optional<Profession> professionOptional = professionRepository.findById(profession.getId());
        if (professionOptional.isPresent()) {
            Profession professionToUpdate = professionOptional.get();
            professionToUpdate.setName(profession.getName());
            professionToUpdate.setNote(profession.getNote());
            professionRepository.save(professionToUpdate);
        }
    }

    @Override
    public void delete(Integer id) {
        professionRepository.deleteById(id);
    }
}
