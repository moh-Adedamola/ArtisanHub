package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
}
