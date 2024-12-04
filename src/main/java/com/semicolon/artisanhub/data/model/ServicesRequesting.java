package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ServicesRequesting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    @ManyToOne
    @JoinColumn(name = "workman_id", nullable = false)
    private User workman;

    private String location;
    private String description;
    private LocalDateTime requestDate = LocalDateTime.now();
    private boolean isAccepted = false;
}
