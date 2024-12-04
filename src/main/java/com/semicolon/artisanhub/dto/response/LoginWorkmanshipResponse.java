package com.semicolon.artisanhub.dto.response;

import com.semicolon.artisanhub.data.model.RolesUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginWorkmanshipResponse {
    private String message;
    private int status;
    private String email;
    private String name;
    private RolesUser rolesUser;

}
