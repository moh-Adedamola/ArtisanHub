package com.semicolon.artisanhub;

import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.data.model.StatusReview;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.data.repository.ReviewsRepository;
import com.semicolon.artisanhub.data.repository.UserRepository;
import com.semicolon.artisanhub.services.AdminServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class AdminTest {
    @Autowired
    private AdminServices adminService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;



    @BeforeEach
    void setUp(){

    }
    @Test
    void testGetReviewsForWorkmanship() {
        Reviews review1 = new Reviews();
        review1.setId(1L);
        review1.setRating(5);
        review1.setComment("Excellent work");
        review1.setCreateDate(LocalDate.now());
        review1.setUpdateDate(LocalDate.now());
        review1.setRolesUser(RolesUser.WORKMANSHIP);
        reviewsRepository.save(review1);

        Reviews review2 = new Reviews();
        review2.setId(2L);
        review2.setRating(4);
        review2.setComment("Good job");
        review2.setCreateDate(LocalDate.now());
        review2.setUpdateDate(LocalDate.now());
        review2.setRolesUser(RolesUser.WORKMANSHIP);
        reviewsRepository.save(review2);


        assertEquals(2, reviewsRepository.count());
        System.out.println("first review " + reviewsRepository.findAll().getFirst().toString());
        System.out.println("last review " + reviewsRepository.findAll().getFirst().toString());

        List<Reviews> reviews = adminService.showAllReviewsForWorkmanship();
//
//        // Debugging output
//        System.out.println("Total reviews fetched: " + reviews.size());
//        for (Reviews review : reviews) {
//            System.out.println("Review: " + review.getComment());
//        }
//
//        // Assert the size of reviews
        assertEquals(2, reviews.size(), "There should be two reviews for the workmanship user");
//        assertEquals("Great work!", reviews.get(0).getComment(), "The first review comment should match");
//        assertEquals("Good job!", reviews.get(1).getComment(), "The second review comment should match");
    }
    }


