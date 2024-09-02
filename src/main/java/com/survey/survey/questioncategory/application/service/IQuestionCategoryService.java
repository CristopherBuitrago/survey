package com.survey.survey.questioncategory.application.service;

import java.util.List;

import java.util.Optional;

import com.survey.survey.questioncategory.domain.entity.QuestionCategory;

public interface IQuestionCategoryService {
    List<QuestionCategory> findAll();
    Optional<QuestionCategory> findById(int id);
    QuestionCategory save(QuestionCategory questionCategory);
    Optional<QuestionCategory> updateById(int id, QuestionCategory questionCategory);
    Optional<QuestionCategory> deleteById(int id);
}
