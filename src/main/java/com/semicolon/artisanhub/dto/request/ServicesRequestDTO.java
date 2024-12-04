package com.semicolon.artisanhub.dto.request;

import lombok.Data;

@Data
public class ServicesRequestDTO {
    private Long requesterId;
    private Long workmanId;
    private String location;
    private String description;
}
