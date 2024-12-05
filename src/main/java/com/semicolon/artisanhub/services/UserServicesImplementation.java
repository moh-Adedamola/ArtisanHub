package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.data.repository.UserRepository;
import com.semicolon.artisanhub.dto.request.LoginWorkmanshipRequest;
import com.semicolon.artisanhub.dto.request.RegisterUserClientRequest;
import com.semicolon.artisanhub.dto.request.RegisterWorkmanshipRequest;
import com.semicolon.artisanhub.dto.response.LoginWorkmanshipResponse;
import com.semicolon.artisanhub.dto.response.RegisterUserClientResponse;
import com.semicolon.artisanhub.dto.response.RegisterWorkmanshipResponse;
import com.semicolon.artisanhub.exceptions.InvalidLoginException;
import com.semicolon.artisanhub.exceptions.UsersAlreadyExistExceptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImplementation implements UsersInterface{
    @Autowired
    private UserRepository userRepository;

    private final ModelMapper mapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public UserServicesImplementation(ModelMapper mapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.mapper = mapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public RegisterWorkmanshipResponse RegisterWorkmanship(RegisterWorkmanshipRequest request)  {
        validationDataBase(request);

        User newUser = mapper.map(request, User.class);
        newUser.setRolesUser(RolesUser.WORKMANSHIP);
        newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        newUser = userRepository.save(newUser);
        RegisterWorkmanshipResponse response = mapper.map(newUser, RegisterWorkmanshipResponse.class);
        response.setMessage("You have successfully registered as a workmanship");


        return response;
    }

    private void validationDataBase(RegisterWorkmanshipRequest request) {
        User existingUserByUsername = userRepository.findByUserName(request.getUserName());
        if (existingUserByUsername != null) {
            throw new UsersAlreadyExistExceptions("Username already exists: " + request.getUserName());
        }

        Optional<User> userWorkmanship = userRepository.findByEmail(request.getEmail());
        if (userWorkmanship.isPresent()) {
            throw  new UsersAlreadyExistExceptions("Workmanship with the given email"+ request.getEmail()+"already exist");

        }
    }

    @Override
    public LoginWorkmanshipResponse LoginWorkmanship(LoginWorkmanshipRequest request) {
        System.out.println("Received login request for email: " + request.getEmail());
            User existingWorkManShip = userRepository.findByEmail(request.getEmail())

                    .orElseThrow(() -> new InvalidLoginException("Invalid email or password"));
        System.out.println("No user found for email: " + request.getEmail());


        if (!bCryptPasswordEncoder.matches(request.getPassword(), existingWorkManShip.getPassword())) {
            System.out.println("Password mismatch for email: " + request.getEmail());
            throw new InvalidLoginException("Invalid email or password");
        }

        return LoginWorkmanshipResponse.builder()
                .email(existingWorkManShip.getEmail())
                .message("Logged in successfully")
                .rolesUser(existingWorkManShip.getRolesUser())
                .status(200)
                .build();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found with the given email"));
    }

    @Override
    public List<User> findWorkmanshipByCity(String city) {
        return userRepository.findByCityAndRolesUser(city, RolesUser.WORKMANSHIP);
    }

    @Override
    public RegisterUserClientResponse registerUserClient(RegisterUserClientRequest registerUserClientRequest) {
//        validateRegisterRequest(registerUserRequest);
//        validateEmail(registerUserRequest.getEmail());
//
        User userClient = new User();
        userClient.setName(registerUserClientRequest.getName());
        userClient.setEmail(registerUserClientRequest.getEmail());
        userClient.setPassword(bCryptPasswordEncoder.encode(registerUserClientRequest.getPassword()));
        userClient.setPhoneNumber(registerUserClientRequest.getPhoneNumber());
        userClient.setPassword(registerUserClientRequest.getPassword());
        userClient.setUserName(registerUserClientRequest.getUserName());
        userClient.setAddress(registerUserClientRequest.getAddress());
        userClient.setCity(registerUserClientRequest.getCity());
        userClient.setState(registerUserClientRequest.getState());
        userClient.setRolesUser(RolesUser.NORMAL_USER);
        userRepository.save(userClient);
        RegisterUserClientResponse registerUserClientResponse = new RegisterUserClientResponse();
        registerUserClientResponse.setMessage("Registration successful");
        return registerUserClientResponse;
    }
}
