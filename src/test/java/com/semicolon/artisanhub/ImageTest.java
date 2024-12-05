package com.semicolon.artisanhub;

import com.semicolon.artisanhub.data.model.Format_Image;
import com.semicolon.artisanhub.dto.request.ImageRequest;
import com.semicolon.artisanhub.dto.request.RegisterWorkmanshipRequest;
import com.semicolon.artisanhub.dto.response.ImageResponse;
import com.semicolon.artisanhub.dto.response.RegisterWorkmanshipResponse;
import com.semicolon.artisanhub.services.ImageServices;
import com.semicolon.artisanhub.services.UsersServices;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ImageTest {


    @Autowired
    private ImageServices images;

    @Autowired
     private UsersServices usersInterface;



    @Test
    @Transactional
    public void test_That_I_Can_Upload_Image() {
        RegisterWorkmanshipRequest registerRequest = new RegisterWorkmanshipRequest();
        registerRequest.setName("John");
        registerRequest.setEmail("john.portable@example.com");
        registerRequest.setPhoneNumber("1234560890");
        registerRequest.setPassword("passwords");
        registerRequest.setUserName("johndan");
        registerRequest.setAddress("123 Main St");


        // Call the RegisterWorkmanship method to register the user
        RegisterWorkmanshipResponse registerResponse = usersInterface.RegisterWorkmanship(registerRequest);

        // Ensure the user was successfully registered
        assertNotNull(registerResponse);
        assertEquals("You have successfully registered as a workmanship", registerResponse.getMessage());

        // Step 2: Create an ImageRequest using the registered user's Id
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setImageUrl("http://example.com/image.jpg");
        imageRequest.setSize(200L);
        imageRequest.setFormat(Format_Image.GIF);
        imageRequest.setAltText("Picture of a man");
        imageRequest.setUserId(registerResponse.getId());  // Use the ID from the registered user

        // Step 3: Upload the image
        ImageResponse imageResponse = images.UploadImage(imageRequest);

        // Step 4: Assertions
        assertNotNull(imageResponse);
        assertEquals("Picture uploaded successfully", imageResponse.getMessage());
        assertEquals("Picture of a man", imageResponse.getAltText());


    }
}
