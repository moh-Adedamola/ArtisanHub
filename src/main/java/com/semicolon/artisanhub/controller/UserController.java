package com.semicolon.artisanhub.controller;

import com.semicolon.artisanhub.dto.request.LoginWorkmanshipRequest;
import com.semicolon.artisanhub.dto.request.RegisterWorkmanshipRequest;
import com.semicolon.artisanhub.dto.response.ApiResponse;
import com.semicolon.artisanhub.dto.response.LoginWorkmanshipResponse;
import com.semicolon.artisanhub.dto.response.RegisterWorkmanshipResponse;
import com.semicolon.artisanhub.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UsersServices usersServices;


    @PostMapping("/registerAsWorkmanship")
    public ResponseEntity<ApiResponse> registerWorkmanship(@RequestBody RegisterWorkmanshipRequest registerWorkmanshipRequest) {
        try {
            RegisterWorkmanshipResponse response = usersServices.RegisterWorkmanship(registerWorkmanshipRequest);
            return new ResponseEntity<>(new ApiResponse(response, true), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginWorkmanship(@RequestBody LoginWorkmanshipRequest request) {
        try {
            LoginWorkmanshipResponse response = usersServices.LoginWorkmanship(request);
            return new ResponseEntity<>(new ApiResponse(response, true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(new ApiResponse(usersServices.getUserById(id), true), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/workmanship/address")
    public ResponseEntity<ApiResponse> findWorkmanshipByAddress(@RequestParam String address) {
        try {
            return new ResponseEntity<>(new ApiResponse(usersServices.findWorkmanshipByAddress(address), true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/normal-users")
    public ResponseEntity<ApiResponse> getNormalUsers() {
        try {
            return new ResponseEntity<>(new ApiResponse(usersServices.getUserList(), true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        try {
            usersServices.deleteUser(id);
            return new ResponseEntity<>(new ApiResponse("User successfully deleted", true), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.NOT_FOUND);
        }
    }
}
