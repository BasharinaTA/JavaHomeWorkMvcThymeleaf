package com.homework_mvc_thymeleaf.controllers;

import com.homework_mvc_thymeleaf.model.Department;
import com.homework_mvc_thymeleaf.services.department.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/department")
public class DepartmentController {
    private DepartmentService departmentService;

    @GetMapping
    public String departments(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("departments", departmentService.getAll());
        return "departments";
    }

    @PostMapping
    public String add(Department department, @RequestParam(required = false) String parentId) {
        try {
            Integer pId = !parentId.isEmpty() ? Integer.parseInt(parentId) : null;
            if ( pId!= null) {
                department.setParentDept(departmentService.get(pId));
            }
            departmentService.save(department);
        } catch (Exception ignore) {

        }
        return "redirect:/admin/department";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(Model model, @PathVariable Integer id) {
        model.addAttribute("department", departmentService.get(id));
        model.addAttribute("departments", departmentService.getAll());
        return "departments";
    }

    @PostMapping("/{id}")
    public String update(Department department, @RequestParam(required = false) String parentId) {
        try {
            Integer pId = !parentId.isEmpty() ? Integer.parseInt(parentId) : null;
            departmentService.update(department.getId(), department.getName(), department.getNote(), pId);
        } catch (Exception ignore) {

        }
        return "redirect:/admin/department";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentService.delete(id);
        return "redirect:/admin/department";
    }
}
