package com.homework_mvc_thymeleaf.controllers;

import com.homework_mvc_thymeleaf.model.entities.Department;
import com.homework_mvc_thymeleaf.services.department.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @GetMapping
    @PreAuthorize("hasAuthority('DEPARTMENT_READ')")
    public String departments(Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("departments", departmentService.getAllOrderById());
        return "pages/departments";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('DEPARTMENT_WRITE')")
    public String add(Department department, @RequestParam(required = false) String parentId) {
        try {
            Integer pId = !parentId.isEmpty() ? Integer.parseInt(parentId) : null;
            if (pId != null) {
                department.setParentDept(departmentService.get(pId));
            }
            departmentService.save(department);
        } catch (Exception ignore) {

        }
        return "redirect:/admin/departments";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('DEPARTMENT_WRITE')")
    public String getEditPage(Model model, @PathVariable Integer id) {
        model.addAttribute("department", departmentService.get(id));
        model.addAttribute("departments", departmentService.getAllOrderById());
        return "pages/departments";
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('DEPARTMENT_WRITE')")
    public String update(Department department, @RequestParam(required = false) String parentId) {
        try {
            Integer pId = !parentId.isEmpty() ? Integer.parseInt(parentId) : null;
            departmentService.update(department, pId);
        } catch (Exception ignore) {

        }
        return "redirect:/admin/departments";
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('DEPARTMENT_WRITE')")
    public String delete(@PathVariable Integer id) {
        departmentService.delete(id);
        return "redirect:/admin/departments";
    }
}
