package com.survey.survey.survey.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.survey.domain.entity.Survey;

public interface ISurveyService {
    // create
    Survey save(Survey survey);
    // update
    Optional<Survey> update(int id, Survey survey);
    // delete
    Optional<Survey> deleteById(int id);
    // find all
    List<Survey> findAll();
    // find one by id
    Optional<Survey> findById(int id);
}
