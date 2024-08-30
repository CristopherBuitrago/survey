package com.survey.survey.categoriescatalog.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.survey.categoriescatalog.domain.entity.CategoriesCatalog;

public interface CategoriesCatalogRepository extends JpaRepository<CategoriesCatalog, Integer>{
    Optional<CategoriesCatalog> findByName(String name);
}
