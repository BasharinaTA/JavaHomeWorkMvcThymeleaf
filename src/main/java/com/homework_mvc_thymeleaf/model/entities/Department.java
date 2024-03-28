package com.homework_mvc_thymeleaf.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="departments")
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="note")
    private String note;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Department parentDept;

    @OneToMany(mappedBy="parentDept")
    private Set<Department> subDepartment;

    @OneToMany(mappedBy="department")
    private Set<Employee> emps;
}
