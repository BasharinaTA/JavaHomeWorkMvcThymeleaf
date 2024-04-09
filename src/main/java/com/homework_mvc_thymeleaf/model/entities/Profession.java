package com.homework_mvc_thymeleaf.model.entities;

import javax.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
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

    @OneToMany(mappedBy="profession")
    private Set<Employee> emps;
}
