package com.survey.survey.optioncategory.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.survey.optioncategory.domain.entity.OptionCategory;

public interface OptionCategoryRepository extends JpaRepository<OptionCategory, Integer>{
    Optional<OptionCategory> findByName(String name);
}
