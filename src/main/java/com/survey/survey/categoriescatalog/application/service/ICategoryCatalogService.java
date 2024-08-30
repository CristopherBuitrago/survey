package com.survey.survey.categoriescatalog.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.categoriescatalog.domain.entity.CategoriesCatalog;

public interface ICategoryCatalogService {
    CategoriesCatalog save(CategoriesCatalog category);
    Optional<CategoriesCatalog> deleteById(int id);
    Optional<CategoriesCatalog> updateById(int id, CategoriesCatalog updatedCategory);
    List<CategoriesCatalog> findAll();
    Optional<CategoriesCatalog> findByName(String name);
}
