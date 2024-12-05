package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Admin {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @NotNull(message = "name cannot be empty pls input a value")
    private String name;
    @NotNull(message = "password cannot be empty pls input your password")
    private String password;
    @Email
    @NotNull(message = "email cannot be empty pls input a value")
    private String email;
    @NotNull(message = "phone number cannot be empty pls input a value")
    private String phoneNumber;
    @NotNull(message = "username cannot be empty pls input a value")
    private String userName;
    @OneToMany
    private List<Reviews> reviews;
}
