package com.homework_mvc_thymeleaf.controllers;

import com.homework_mvc_thymeleaf.model.entities.Profession;
import com.homework_mvc_thymeleaf.services.profession.ProfessionService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/professions")
public class ProfessionController {
    private ProfessionService professionService;

    @GetMapping
    @PreAuthorize("hasAuthority('PROFESSION_READ')")
    public String professions(Model model) {
        model.addAttribute("profession", new Profession());
        model.addAttribute("professions", professionService.getAllOrderById());
        return "pages/professions";
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('PROFESSION_WRITE')")
    public String add(Profession profession) {
        professionService.save(profession);
        return "redirect:/admin/professions";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('PROFESSION_WRITE')")
    public String getEditPage(Model model, @PathVariable Integer id) {
        model.addAttribute("profession", professionService.get(id));
        model.addAttribute("professions", professionService.getAllOrderById());
        return "pages/professions";
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('PROFESSION_WRITE')")
    public String update(Profession profession) {
        professionService.update(profession);
        return "redirect:/admin/professions";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('PROFESSION_WRITE')")
    public String delete(@PathVariable Integer id) {
        professionService.delete(id);
        return "redirect:/admin/professions";
    }
}
