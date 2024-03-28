package com.homework_mvc_thymeleaf.controllers;

import com.homework_mvc_thymeleaf.services.BaseInitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/service")
public class BaseInitController {
    private BaseInitService baseInitService;

    @GetMapping("/generate")
    public String generate() {
        baseInitService.deptsInit();
        baseInitService.profsInit();
        return "redirect:/";
    }
}
