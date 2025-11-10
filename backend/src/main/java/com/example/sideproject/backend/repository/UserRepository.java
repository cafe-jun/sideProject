package com.example.sideproject.backend.repository;

import com.example.sideproject.backend.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> { }
