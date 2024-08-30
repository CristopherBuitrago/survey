package com.survey.survey.auth.user.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.survey.auth.user.domain.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
