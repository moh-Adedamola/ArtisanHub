package com.semicolon.artisanhub;

import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.data.repository.UserRepository;
import com.semicolon.artisanhub.dto.request.RegisterUserClientRequest;
import com.semicolon.artisanhub.dto.response.RegisterUserClientResponse;
import com.semicolon.artisanhub.exceptions.UsersAlreadyExistExceptions;
import com.semicolon.artisanhub.services.UsersInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UsersInterface usersInterface;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testToRegisterUserClient() {
        RegisterUserClientRequest registerUserClientRequest = new RegisterUserClientRequest();
        registerUserClientRequest.setName("adegbite mohammed");
        registerUserClientRequest.setEmail("adegbitemohammed@gmail.com");
        registerUserClientRequest.setPhoneNumber("07068335394");
        registerUserClientRequest.setPassword("123456");
        registerUserClientRequest.setUserName("adedamola");
        registerUserClientRequest.setAddress("no 10 adepoju street");
        registerUserClientRequest.setCity("lagos");
        registerUserClientRequest.setState("Lagos");
        registerUserClientRequest.setRolesUser(RolesUser.NORMAL_USER);
        RegisterUserClientResponse registerUserClientResponse = usersInterface.registerUserClient(registerUserClientRequest);
        assertNotNull(registerUserClientResponse);
        assertThat(registerUserClientResponse.getMessage()).isEqualTo("Registration successful");
//        assertThrows(UsersAlreadyExistExceptions.class, ()-> usersInterface.registerUserClient(registerUserClientRequest));

    }

    @Test
    public void testThatUserClientLogin(){
        
    }



}
