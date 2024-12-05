package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.data.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServicesImplementation implements ReviewServices {
    @Autowired
    private ReviewsRepository reviewsRepository;
    @Override
    public List<Reviews> showAllReviewsForWorkmanship() {
        return reviewsRepository.findByRolesUser(RolesUser.WORKMANSHIP);
    }
}
