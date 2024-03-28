package com.homework_mvc_thymeleaf.converter;

import com.homework_mvc_thymeleaf.model.dto.EmployeeDto;
import com.homework_mvc_thymeleaf.model.entities.Department;
import com.homework_mvc_thymeleaf.model.entities.Employee;
import com.homework_mvc_thymeleaf.model.entities.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EmployeeConverter {

    @Mapping(target = "deptId", source = "employee.department.id")
    @Mapping(target = "profId", source = "employee.profession.id")
    EmployeeDto toDto(Employee employee);

    @Mapping(target = "id", source = "employeeDto.id")
    @Mapping(target = "fio", source = "employeeDto.fio")
    @Mapping(target = "note", source = "employeeDto.note")
    @Mapping(target = "department", source = "department")
    @Mapping(target = "profession", source = "profession")
    Employee toEntity(EmployeeDto employeeDto, Department department, Profession profession);
}
