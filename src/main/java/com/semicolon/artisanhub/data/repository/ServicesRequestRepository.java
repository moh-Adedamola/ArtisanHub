package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.ServicesRequesting;
import com.semicolon.artisanhub.data.model.SpecializationArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicesRequestRepository extends JpaRepository<ServicesRequesting,Long> {

}
