package com.survey.survey.categoriescatalog.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.categoriescatalog.application.service.ICategoryCatalogService;
import com.survey.survey.categoriescatalog.domain.entity.CategoriesCatalog;

import jakarta.transaction.Transactional;

@Service
public class CatalogCategoriesAdapter implements ICategoryCatalogService {

    @Autowired
    private CategoriesCatalogRepository categoryRepository;

    @Override
    @Transactional
    public CategoriesCatalog save(CategoriesCatalog category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Optional<CategoriesCatalog> deleteById(int id) {
        Optional<CategoriesCatalog> foundCategory = categoryRepository.findById(id);

        if (foundCategory.isPresent()) {
            categoryRepository.deleteById(id);
            return foundCategory;
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<CategoriesCatalog> updateById(int id, CategoriesCatalog updatedCategory) {
        Optional<CategoriesCatalog> foundCategory = categoryRepository.findById(id);

        if (foundCategory.isPresent()) {
            CategoriesCatalog existingCategory = foundCategory.get();
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setSurveys(updatedCategory.getSurveys());
            return Optional.of(categoryRepository.save(existingCategory));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<CategoriesCatalog> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoriesCatalog> findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Optional<CategoriesCatalog> findById(int id) {
        return categoryRepository.findById(id);
    }
}
