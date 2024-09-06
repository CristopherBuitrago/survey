package com.survey.survey.auth.user.infrastructure.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.survey.auth.user.domain.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
