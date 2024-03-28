package com.homework_mvc_thymeleaf.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Integer id;
    private String fio;
    private String note;
    private Integer deptId;
    private Integer profId;
}
