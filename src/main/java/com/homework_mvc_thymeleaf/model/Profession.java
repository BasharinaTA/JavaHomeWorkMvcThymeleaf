package com.homework_mvc_thymeleaf.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="professions")
public class Profession {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="note")
    private String note;

    @OneToMany
    @JoinColumn(name="profession_id")
    private Set<Employee> emps;
}
