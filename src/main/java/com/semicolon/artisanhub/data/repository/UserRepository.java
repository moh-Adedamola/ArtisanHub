package com.semicolon.artisanhub.data.repository;

import com.semicolon.artisanhub.data.model.RolesUser;
import com.semicolon.artisanhub.data.model.User;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    Optional<User> findByEmail(String email);
    List<User> findByRolesUser(RolesUser rolesUser);
    List<User> findByAddressAndRolesUser(String Address,RolesUser rolesUser);
}
