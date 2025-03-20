package com.example.CaloriTrack.repository;

import com.example.CaloriTrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}