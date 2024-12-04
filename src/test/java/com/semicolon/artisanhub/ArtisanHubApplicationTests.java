package com.semicolon.artisanhub;

import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.dto.request.LoginWorkmanshipRequest;
import com.semicolon.artisanhub.dto.request.RegisterWorkmanshipRequest;
import com.semicolon.artisanhub.dto.response.LoginWorkmanshipResponse;
import com.semicolon.artisanhub.dto.response.RegisterWorkmanshipResponse;
import com.semicolon.artisanhub.exceptions.InvalidLoginException;
import com.semicolon.artisanhub.services.UserServicesImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArtisanHubApplicationTests {

    @Autowired
    private UserServicesImplementation userServicesImplementation;

    @Test
    void contextLoads() {
    }
    @Test
    void test_That_You_Can_Register_As_A_workmanship() {
        RegisterWorkmanshipRequest request = CreateRegisterWorkmanshipRequest();
        RegisterWorkmanshipResponse response = userServicesImplementation.RegisterWorkmanship(request);
        response.setMessage("You have successfully registered as a workmanship");
        assertNotNull(response, "Response should not be null");
        assertEquals("You have successfully registered as a workmanship", response.getMessage());
        assertEquals(request.getCity(), response.getCity());
        assertEquals(request.getAddress(), response.getAddress());
        assertEquals(request.getPhoneNumber(), response.getPhoneNumber());
        assertEquals(request.getEmail(), response.getEmail());

    }

    private static RegisterWorkmanshipRequest CreateRegisterWorkmanshipRequest() {
        RegisterWorkmanshipRequest request = new RegisterWorkmanshipRequest();
        request.setName("toluwalase");
        request.setEmail("toluwalase@gmail.com");
        request.setPassword("123456");
        request.setPhoneNumber("08134567890");
        request.setAddress("sabo yaba 12 herbert marculey");
        request.setCity("Sabo Yaba");
        request.setState("Lagos");
        request.setUserName("Obaturn");
        request.setRolesUser(RolesUser.WORKMANSHIP);
        return request;
    }

    @Test
    void testLoginAsWorkmanship() {
        LoginWorkmanshipRequest request = new LoginWorkmanshipRequest();
        request.setEmail("toluwalase@gmail.com");
        request.setPassword("123456");

        LoginWorkmanshipResponse response = userServicesImplementation.LoginWorkmanship(request);

        assertNotNull(response);
        assertEquals("Logged in successfully", response.getMessage());
    }

    @Test
    void testLoginInvalidCredentials() {
        LoginWorkmanshipRequest request = new LoginWorkmanshipRequest();
        request.setEmail("invalid.email@gmail.com");
        request.setPassword("wrongPassword");

        assertThrows(InvalidLoginException.class, () -> {
            userServicesImplementation.LoginWorkmanship(request);
        });

    }
}
