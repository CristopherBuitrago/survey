package com.survey.survey.auth.role.infrastructure.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.survey.auth.role.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
