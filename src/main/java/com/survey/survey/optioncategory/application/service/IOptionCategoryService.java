package com.survey.survey.optioncategory.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.optioncategory.domain.entity.OptionCategory;

public interface IOptionCategoryService {
    //create
    OptionCategory save(OptionCategory optionCategory);
    //read
    List<OptionCategory> findAll();
    Optional<OptionCategory> findById(int id);
    Optional<OptionCategory> findByName(String name);
    //update
    Optional<OptionCategory> updateById(int id, OptionCategory optionCategory);
    //delete
    Optional<OptionCategory> deleteById(int id);
}
