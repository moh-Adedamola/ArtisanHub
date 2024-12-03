package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotBlank(message = "name cannot be empty pls input your name")
    @Column(nullable = false)
    private String name;

    @Email(message = "Email is empty pls input the correct email")
    @Column(nullable = false, unique = true,length = 150)
    private String email;

    @NotBlank(message = "phone number cannot be empty pls input your phoneNumber")
    @Column(nullable = false , length = 11)
    private String phoneNumber;

    @NotBlank(message = "password cannot be empty pls input your password")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "username cannot be empty pls input your username")
    @Column(nullable = false , length = 150, unique = true)
    private String userName;

    @NotBlank(message = "address cannot be empty pls input your address")
    @Column(nullable = false)
    private String address;

    @NotBlank(message = "City cannot be empty pls input your city ")
    @Column(nullable = false)
    private String city;

    @NotBlank(message = "state cannot be empty pls input a state ")
    @Column(nullable = false)
    private String state;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "user")
    private Image profilePicture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RolesUser rolesUser;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<SpecializationArea> specializationArea;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "workmanship")
    private List<Reviews> reviews;

}
