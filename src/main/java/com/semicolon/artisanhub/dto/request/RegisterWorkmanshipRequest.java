package com.semicolon.artisanhub.dto.request;

import com.semicolon.artisanhub.data.model.Image;
import com.semicolon.artisanhub.data.model.RolesUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterWorkmanshipRequest {
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

    @NotBlank(message = "City cannot be empty pls input your city ")
    private String city;

    @NotBlank(message = "state cannot be empty pls input a state ")
    private String state;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "user")
    private Image profilePicture;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Roles cannot be empty pls input a roles that you are")
    private RolesUser rolesUser;



}
