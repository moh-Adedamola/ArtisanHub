package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.dto.request.RegisterAsAdminRequest;
import com.semicolon.artisanhub.dto.response.AdminRegisterResponse;

import java.util.List;

public interface AdminServices {
    AdminRegisterResponse RegisterAsAnAdmin(RegisterAsAdminRequest registerAsAdminRequest);
    List<Reviews> showAllReviewsForWorkmanship();
    List<User> getUserList();
     void deleteUser(Long id);
}
