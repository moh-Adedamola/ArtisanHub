package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Image {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @NotBlank(message = "ïmage link cannot be empty pls input a URL for it")
    private String imageUrl;

    @NotBlank(message = "pls input a value for the description of ALT")
    private String altText;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "pls select a image type")
    private Format_Image format;

    private Long size;



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
