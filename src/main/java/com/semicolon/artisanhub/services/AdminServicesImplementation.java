package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class AdminServicesImplementation implements AdminServices {
    private UserRepository userRepository;



    @Override
    public List<Reviews> showAllReviewsForWorkmanship() {
        List<User> workmanshipUsers = userRepository.findByRolesUser(RolesUser.WORKMANSHIP);
        List<Reviews> allReviews = new ArrayList<>();

        if (workmanshipUsers != null) {
            for (User workmanshipUser : workmanshipUsers) {


                List<Reviews> reviews = workmanshipUser.getReviews();
                if (reviews != null) {
                    allReviews.addAll(reviews);
                }
            }
        }


        return allReviews;
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findByRolesUser(RolesUser.NORMAL_USER);
    }
    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (user.getRolesUser() == RolesUser.WORKMANSHIP) {
            userRepository.delete(user);
        } else {
            throw new RuntimeException("User is not a workmanship");
        }
    }
}
