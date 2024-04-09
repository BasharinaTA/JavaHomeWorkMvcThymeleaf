package com.homework_mvc_thymeleaf.model.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(
            Authority.PROFESSION_READ,
            Authority.EMPLOYEE_READ,
            Authority.DEPARTMENT_READ,
            Authority.BROWSE
    )),
    ADMIN(Set.of(
            Authority.PROFESSION_READ,
            Authority.PROFESSION_WRITE,
            Authority.EMPLOYEE_READ,
            Authority.EMPLOYEE_WRITE,
            Authority.DEPARTMENT_READ,
            Authority.DEPARTMENT_WRITE,
            Authority.BROWSE)),
    LOSER(Set.of(Authority.BROWSE));

    private final Set<Authority> authorities;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return authorities.stream()
                .map(auth -> new SimpleGrantedAuthority(auth.name()))
                .collect(Collectors.toSet());
    }

    Role(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    ;
}
