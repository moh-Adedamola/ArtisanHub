package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Reviews {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


    private int rating;


    private String comment;



    private LocalDate createDate;

    private LocalDate updateDate;

    @Enumerated(EnumType.STRING)
    private StatusReview statusReview;

    private RolesUser rolesUser;
}
