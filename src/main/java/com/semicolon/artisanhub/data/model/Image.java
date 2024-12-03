package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Image {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String altText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Format_Image format;

    @Column(nullable = false)
    private Long size;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
