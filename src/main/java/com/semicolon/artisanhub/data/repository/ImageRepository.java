package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
