package com.semicolon.artisanhub.services;

import com.semicolon.artisanhub.dto.request.ImageRequest;
import com.semicolon.artisanhub.dto.response.ImageResponse;

public interface ImageServices {
     ImageResponse UploadImage(ImageRequest imageRequest);
}
