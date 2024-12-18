package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.SpecializationArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecializationAreaRepository extends JpaRepository<SpecializationArea, Long> {
    Optional<SpecializationArea> findByUser_Id(Long userId);
}
