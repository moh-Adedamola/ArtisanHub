package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.Admin;
import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.data.repository.AdminRepository;
import com.semicolon.artisanhub.dto.request.RegisterAsAdminRequest;
import com.semicolon.artisanhub.dto.response.AdminRegisterResponse;
import com.semicolon.artisanhub.exceptions.UsersAlreadyExistExceptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AdminServicesImplementation implements AdminServices {

    @Autowired
    private  AdminRepository adminRepository;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired private UsersServices userService;
    @Autowired private ReviewServices reviewService;
    @Autowired private NotificationService notificationService;

    @Override
    public AdminRegisterResponse RegisterAsAnAdmin(RegisterAsAdminRequest registerAsAdminRequest) {
        Admin admin = adminRepository.findByUserName(registerAsAdminRequest.getUserName());
        if (admin != null) {
            throw new UsersAlreadyExistExceptions("user already exists with the given username");
        }
        Admin newAdmin = modelMapper.map(registerAsAdminRequest, Admin.class);
        newAdmin.setPassword(bCryptPasswordEncoder.encode(registerAsAdminRequest.getPassword()));
        adminRepository.save(newAdmin);
        notificationService.sendNotification(
                newAdmin.getEmail(),
                "Registration Successful",
                "Welcome " + newAdmin.getUserName()+"We are to tell you that"+
                        "we are so glad to have you in  ArtisanHub platform thanks for being part of our administrator"
        );


        return getAdminRegisterResponse();

    }

    private static  AdminRegisterResponse getAdminRegisterResponse() {
        AdminRegisterResponse adminRegisterResponse = new AdminRegisterResponse();
        adminRegisterResponse.setMessage("You have successfully registered as an admin");
        adminRegisterResponse.setStatus(200);
        return adminRegisterResponse;
    }

    @Override
    public List<Reviews> showAllReviewsForWorkmanship() {
        return reviewService.showAllReviewsForWorkmanship();
    }

    @Override
    public List<User> getUserList() {
        return userService.getUserList();
    }
    @Override
    public void deleteUser(Long id) {

        userService.deleteUser(id);
    }
}
