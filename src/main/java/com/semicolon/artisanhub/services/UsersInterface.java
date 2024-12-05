package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.dto.request.LoginWorkmanshipRequest;
import com.semicolon.artisanhub.dto.request.RegisterUserClientRequest;
import com.semicolon.artisanhub.dto.request.RegisterWorkmanshipRequest;
import com.semicolon.artisanhub.dto.response.LoginWorkmanshipResponse;
import com.semicolon.artisanhub.dto.response.RegisterUserClientResponse;
import com.semicolon.artisanhub.dto.response.RegisterWorkmanshipResponse;

import java.util.List;

public interface UsersInterface {
    RegisterWorkmanshipResponse RegisterWorkmanship(RegisterWorkmanshipRequest request);
    LoginWorkmanshipResponse LoginWorkmanship(LoginWorkmanshipRequest request);
    User getUserById(Long id);
    List<User> findWorkmanshipByCity(String city);

    RegisterUserClientResponse registerUserClient(RegisterUserClientRequest registerUserClientRequest);
}
