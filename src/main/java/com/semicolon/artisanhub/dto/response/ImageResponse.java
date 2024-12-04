package com.semicolon.artisanhub.dto.response;

import com.semicolon.artisanhub.data.model.Format_Image;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ImageResponse {
    private Long id;
    private String url;
    private String message;

    private String altText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Format_Image format;
}
