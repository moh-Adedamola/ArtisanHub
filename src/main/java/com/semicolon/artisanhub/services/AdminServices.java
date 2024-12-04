package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.User;

import java.util.List;

public interface AdminServices {
    List<Reviews> showAllReviewsForWorkmanship();
    List<User> getUserList();
     void deleteUser(Long id);
}
