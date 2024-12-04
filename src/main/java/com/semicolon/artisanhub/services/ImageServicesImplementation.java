package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.data.model.Format_Image;
import com.semicolon.artisanhub.data.model.Image;
import com.semicolon.artisanhub.data.model.User;
import com.semicolon.artisanhub.data.repository.ImageRepository;
import com.semicolon.artisanhub.data.repository.UserRepository;
import com.semicolon.artisanhub.dto.request.ImageRequest;
import com.semicolon.artisanhub.dto.response.ImageResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServicesImplementation implements ImageServices {

    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Override
    public ImageResponse UploadImage(ImageRequest imageRequest) {
        User users = userRepository.findById(imageRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with the given id "));
        Image image = modelMapper.map(imageRequest, Image.class);
        image.setUser(users);

        imageRepository.save(image);
        return ImageResponse.builder()

                .id(image.getId())
                .url(imageRequest.getImageUrl())
                .altText(imageRequest.getAltText())
                .message("picture uploaded successfully")
                .format(Format_Image.GIF)
                .build();
    }
}
