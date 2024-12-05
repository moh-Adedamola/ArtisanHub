package com.semicolon.artisanhub.data.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotBlank(message = "name cannot be empty pls input your name")
    private String name;

    @Email(message = "Email is empty pls input the correct email")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "phone number cannot be empty pls input your phoneNumber")
    @Column(length = 11)
    private String phoneNumber;

    @NotBlank(message = "password cannot be empty pls input your password")
    private String password;

    @NotBlank(message = "username cannot be empty pls input your username")
    @Column(unique = true)
    private String userName;

    @NotBlank(message = "address cannot be empty pls input your address")
    private String address;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Image> images = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Roles cannot be empty pls select a roles")
    private RolesUser rolesUser;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<SpecializationArea> specializationArea;

}
