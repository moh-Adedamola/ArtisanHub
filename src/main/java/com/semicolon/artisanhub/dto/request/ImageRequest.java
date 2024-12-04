package com.semicolon.artisanhub.dto.request;

import com.semicolon.artisanhub.data.model.Format_Image;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageRequest {

    @NotBlank(message = "image url cannot be empty")
    private String imageUrl;

    @NotBlank(message = "pls input your description for the ALT Text")
    private String altText;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "pls input a format for the image")
    private Format_Image format;


    private Long size;

    private Long userId;

}
