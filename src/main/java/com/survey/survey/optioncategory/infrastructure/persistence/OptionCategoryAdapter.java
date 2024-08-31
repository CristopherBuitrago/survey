package com.survey.survey.optioncategory.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.optioncategory.application.service.IOptionCategoryService;
import com.survey.survey.optioncategory.domain.entity.OptionCategory;

@Service
public class OptionCategoryAdapter implements IOptionCategoryService{

    @Autowired
    private OptionCategoryRepository optionCategoryRepository;

    @Override
    public OptionCategory save(OptionCategory optionCategory) {
        return optionCategoryRepository.save(optionCategory);
    }

    @Override
    public List<OptionCategory> findAll() {
        return optionCategoryRepository.findAll();
    }

    @Override
    public Optional<OptionCategory> findById(int id) {
        Optional<OptionCategory> foundOptionCategory = optionCategoryRepository.findById(id);

        if (!foundOptionCategory.isPresent()) {
            return Optional.empty();
        } else {
            return foundOptionCategory;
        }
    }

    @Override
    public Optional<OptionCategory> findByName(String name) {
        Optional<OptionCategory> foundOptionCategory = optionCategoryRepository.findByName(name);

        if (!foundOptionCategory.isPresent()) {
            return Optional.empty();
        } else {
            return foundOptionCategory;
        }
    }

    @Override
    public Optional<OptionCategory> updateById(int id, OptionCategory optionCategory) {
        Optional<OptionCategory> foundOptionCategory = optionCategoryRepository.findById(id);

        if (!foundOptionCategory.isPresent()) {
            return Optional.empty();
        } else{
            OptionCategory updatedOptionCategory = foundOptionCategory.get();

            updatedOptionCategory.setId(id);
            updatedOptionCategory.setName(optionCategory.getName());
            updatedOptionCategory.setOptions(optionCategory.getOptions());

            return Optional.of(optionCategoryRepository.save(updatedOptionCategory));
        }
    }

    @Override
    public Optional<OptionCategory> deleteById(int id) {
        Optional<OptionCategory> foundOptionCategory = optionCategoryRepository.findById(id);

        if (!foundOptionCategory.isPresent()) {
            return Optional.empty();
        } else {
            optionCategoryRepository.deleteById(id);
            return foundOptionCategory;
        }
    }

}
