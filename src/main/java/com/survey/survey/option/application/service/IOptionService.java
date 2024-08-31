package com.survey.survey.option.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.option.domain.entity.Option;

public interface IOptionService {
    // create
    Option save(Option option);
    // read
    Optional<Option> findById(int id);
    List<Option> findAll();
    // update
    Optional<Option> update(int id, Option option);
    // delete
    Optional<Option> deleteById(int id);
}
