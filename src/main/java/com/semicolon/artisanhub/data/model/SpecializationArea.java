package com.semicolon.artisanhub.data.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SpecializationArea {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private boolean isAvailable;
    private int yearsOfExperience;

    @Enumerated(EnumType.STRING)
    private WorkCategory workCategory;
    @Enumerated(EnumType.STRING)
    private SubWorkCategory subWorkCategory;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
