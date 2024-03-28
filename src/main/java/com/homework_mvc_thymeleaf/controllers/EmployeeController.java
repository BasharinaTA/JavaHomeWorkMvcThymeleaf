package com.homework_mvc_thymeleaf.controllers;

import com.homework_mvc_thymeleaf.converter.EmployeeConverter;
import com.homework_mvc_thymeleaf.model.dto.EmployeeDto;
import com.homework_mvc_thymeleaf.model.entities.Employee;
import com.homework_mvc_thymeleaf.services.department.DepartmentService;
import com.homework_mvc_thymeleaf.services.employee.EmployeeService;
import com.homework_mvc_thymeleaf.services.profession.ProfessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    private ProfessionService professionService;
    private EmployeeConverter employeeConverter;

    @GetMapping
    public String employees(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        model.addAttribute("employees", employeeService.getAllOrderById()
                .stream()
                .map(employeeConverter::toDto)
                .toList());
        model.addAttribute("departments", departmentService.getAllOrderById());
        model.addAttribute("professions", professionService.getAllOrderById());
        return "pages/employees";
    }

    @PostMapping("/")
    public String add(EmployeeDto employeeDto,
                      @RequestParam(required = false) Integer deptId,
                      @RequestParam(required = false) Integer profId) {
        employeeService.save(employeeConverter.toEntity(employeeDto, departmentService.get(deptId), professionService.get(profId)));
        return "redirect:/admin/employees";
    }


    @PostMapping("/edit/{id}")
    public String getEditPage(Model model, @PathVariable Integer id) {
        model.addAttribute("employee", employeeConverter.toDto(employeeService.get(id)));
        model.addAttribute("employees", employeeService.getAllOrderById()
                .stream()
                .map(employeeConverter::toDto)
                .toList());
        model.addAttribute("departments", departmentService.getAllOrderById());
        model.addAttribute("professions", professionService.getAllOrderById());
        return "pages/employees";
    }

    @PostMapping("{id}")
    public String update(EmployeeDto employeeDto,
                         @RequestParam(required = false) Integer deptId,
                         @RequestParam(required = false) Integer profId) {
        Employee employee = employeeConverter.toEntity(employeeDto, departmentService.get(deptId), professionService.get(profId));
        employeeService.update(employee);
        return "redirect:/admin/employees";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/admin/employees";
    }
}
