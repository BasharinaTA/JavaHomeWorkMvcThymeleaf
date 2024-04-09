package com.homework_mvc_thymeleaf.model.entities;

import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser {
    public static UserDetails fromEntity(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getRole().getAuthorities()
        );
    }
}
