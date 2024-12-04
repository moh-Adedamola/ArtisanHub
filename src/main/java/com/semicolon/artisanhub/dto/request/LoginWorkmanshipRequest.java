package com.semicolon.artisanhub.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginWorkmanshipRequest {
    private String email;
    private String password;
}
