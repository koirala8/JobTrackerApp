package com.apply24hours.jobtracker.repository;

import com.apply24hours.jobtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // For login or user lookup

    Boolean existsByEmail(String email); // For checking if a user already exists
}
