package com.semicolon.artisanhub.controller;

import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.dto.request.RegisterAsAdminRequest;
import com.semicolon.artisanhub.dto.response.AdminRegisterResponse;
import com.semicolon.artisanhub.dto.response.ApiResponse;
import com.semicolon.artisanhub.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController

@RequestMapping("api/Admin")
public class AdminController {

    @Autowired

    private AdminServices adminServices;
    @PostMapping("/registerAsAnAdmin")
    public ResponseEntity<?> RegisterAsAnAdmin(@RequestBody RegisterAsAdminRequest adminRequest) {
        try{
            AdminRegisterResponse response = adminServices.RegisterAsAnAdmin(adminRequest);
            ApiResponse apiResponse = new ApiResponse(response,true);
            return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
        }catch(Exception e){
            ApiResponse errorResponse = new ApiResponse(e.getMessage(), false);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/reviews")
    public ResponseEntity<ApiResponse> getAllReviewsForWorkmanship() {
        try {
            List<Reviews> reviews = adminServices.showAllReviewsForWorkmanship();
            ApiResponse response = new ApiResponse(reviews, true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(e.getMessage(), false);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/users")
    public ResponseEntity<ApiResponse> getAllUsers() {
        try {
            List<User> users = adminServices.getUserList();
            ApiResponse response = new ApiResponse(users, true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(e.getMessage(), false);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint to delete a user by ID
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        try {
            adminServices.deleteUser(id);
            ApiResponse response = new ApiResponse("User successfully deleted", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(e.getMessage(), false);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
