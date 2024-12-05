package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUserName(String username);
}
