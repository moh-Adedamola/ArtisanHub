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
@Transactional
public class AdminTest {
    @Autowired
    private AdminServices adminService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;

    private User workmanshipUser;
    private Reviews review1, review2;

    @BeforeEach
    void setUp(){
        workmanshipUser = new User();
        workmanshipUser.setName("John Doe");
        workmanshipUser.setEmail("john.doe@example.com");
        workmanshipUser.setPhoneNumber("1234567890");
        workmanshipUser.setPassword("password");
        workmanshipUser.setUserName("john_doe");
        workmanshipUser.setAddress("123 Street");
        workmanshipUser.setCity("City");
        workmanshipUser.setState("State");
        workmanshipUser.setRolesUser(RolesUser.WORKMANSHIP);


        userRepository.save(workmanshipUser);


        review1 = new Reviews();
        review1.setRating(5);
        review1.setComment("Great work!");
        review1.setCreateDate(LocalDate.now());
        review1.setStatusReview(StatusReview.EXCELLENT);
        review1.setWorkmanship(workmanshipUser);

        review2 = new Reviews();
        review2.setRating(4);
        review2.setComment("Good job!");
        review2.setCreateDate(LocalDate.now());
        review2.setStatusReview(StatusReview.GOOD);
        review2.setWorkmanship(workmanshipUser);

        review1.setWorkmanship(workmanshipUser);
        review2.setWorkmanship(workmanshipUser);

        reviewsRepository.save(review1);
        reviewsRepository.save(review2);

    }
    @Test
    void testGetReviewsForWorkmanship() {

        List<Reviews> reviews = adminService.showAllReviewsForWorkmanship();

        // Debugging output
        System.out.println("Total reviews fetched: " + reviews.size());
        for (Reviews review : reviews) {
            System.out.println("Review: " + review.getComment());
        }

        // Assert the size of reviews
        assertEquals(2, reviews.size(), "There should be two reviews for the workmanship user");
        assertEquals("Great work!", reviews.get(0).getComment(), "The first review comment should match");
        assertEquals("Good job!", reviews.get(1).getComment(), "The second review comment should match");
    }
    }


