package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
