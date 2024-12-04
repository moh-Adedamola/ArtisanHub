package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.Image;
import com.semicolon.artisanhub.data.model.Reviews;
import com.semicolon.artisanhub.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
