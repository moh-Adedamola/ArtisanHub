package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Reviews {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false,length = 100)
    private int rating;

    @Column(nullable = false,length = 100)
    private String comment;


    @Column(nullable = false)
    private LocalDate createDate;

    private LocalDate updateDate;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReview statusReview;

    @ManyToOne
    @JoinColumn(name = "workmanship_id", nullable = false)
    private User workmanship;

}
