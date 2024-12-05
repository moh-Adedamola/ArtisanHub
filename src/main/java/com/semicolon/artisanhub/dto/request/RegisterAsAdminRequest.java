package com.semicolon.artisanhub.dto.request;

import lombok.Data;

@Data
public class RegisterAsAdminRequest {
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String userName;
}
