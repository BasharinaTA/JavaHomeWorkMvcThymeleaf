package com.homework_mvc_thymeleaf.services;

import com.homework_mvc_thymeleaf.model.entities.Department;
import com.homework_mvc_thymeleaf.model.entities.Profession;
import com.homework_mvc_thymeleaf.services.department.DepartmentService;
import com.homework_mvc_thymeleaf.services.profession.ProfessionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BaseInitService {
    private DepartmentService departmentService;
    private ProfessionService professionService;

    public void profsInit() {
        professionService.save(Profession.builder().name("ПМ").note("").build());
        professionService.save(Profession.builder().name("Лид").note("").build());
        professionService.save(Profession.builder().name("Разработчик").note("").build());
        professionService.save(Profession.builder().name("Тестировщик").note("").build());
        professionService.save(Profession.builder().name("Дизайнер").note("").build());
        professionService.save(Profession.builder().name("PR-менеджер").note("").build());
        professionService.save(Profession.builder().name("Специалист колл-центра").note("").build());
        professionService.save(Profession.builder().name("Маркетолог").note("").build());
        professionService.save(Profession.builder().name("Бухгалтер").note("").build());
    }

    public void deptsInit() {
        Department root1 = departmentService.save(Department.builder().name("DB").note("отдел по разработке DB").parentDept(null).build());
        Department dev1 = departmentService.save(Department.builder().name("Разработка").note("родитель - 1: DB").parentDept(root1).build());
        departmentService.save(Department.builder().name("Dev").note("родитель - 2: Разработка").parentDept(dev1).build());
        departmentService.save(Department.builder().name("Test").note("родитель - 2: Разработка").parentDept(dev1).build());
        departmentService.save(Department.builder().name("Design").note("родитель - 2: Разработка").parentDept(dev1).build());
        Department mark1 = departmentService.save(Department.builder().name("Маркетинг").note("родитель - 1: DB").parentDept(root1).build());
        departmentService.save(Department.builder().name("Колл-центр").note("родитель - 6: Маркетинг").parentDept(mark1).build());
        departmentService.save(Department.builder().name("Медиа").note("родитель - 6: Маркетинг").parentDept(mark1).build());
        departmentService.save(Department.builder().name("Бухгалтерия").note("родитель - 1: DB").parentDept(root1).build());

        Department root2 = departmentService.save(Department.builder().name("Office").note("отдел по разработке Office").parentDept(null).build());
        Department dev2 = departmentService.save(Department.builder().name("Разработка").note("родитель - 10: Office").parentDept(root2).build());
        departmentService.save(Department.builder().name("Dev").note("родитель - 11: Разработка").parentDept(dev2).build());
        departmentService.save(Department.builder().name("Test").note("родитель - 11: Разработка").parentDept(dev2).build());
        departmentService.save(Department.builder().name("Design").note("родитель - 11: Разработка").parentDept(dev2).build());
        Department mark2 = departmentService.save(Department.builder().name("Маркетинг").note("родитель - 10: Office").parentDept(root2).build());
        departmentService.save(Department.builder().name("Колл-центр").note("родитель - 15: Маркетинг").parentDept(mark2).build());
        departmentService.save(Department.builder().name("Медиа").note("родитель - 15: Маркетинг").parentDept(mark2).build());
        departmentService.save(Department.builder().name("Соц Сети").note("родитель - 15: Маркетинг").parentDept(mark2).build());
        departmentService.save(Department.builder().name("Бухгалтерия").note("родитель - 10: Office").parentDept(root2).build());
        departmentService.getAll().forEach(System.out::println);
    }
}
