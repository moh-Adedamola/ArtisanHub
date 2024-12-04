package com.semicolon.artisanhub.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterWorkmanshipResponse {
    private Long id;
    private String message;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private int status;
}
