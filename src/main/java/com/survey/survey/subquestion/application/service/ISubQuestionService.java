package com.survey.survey.subquestion.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.subquestion.domain.entity.SubQuestion;

public interface ISubQuestionService {
    // get all
    Optional<List<SubQuestion>> findAll();
    // get by id
    Optional<SubQuestion> findById(int id);
    // create
    SubQuestion save(SubQuestion subQuestion);
    // update by id
    Optional<SubQuestion> updateById(int id, SubQuestion subQuestion);
    // delete by id
    Optional<SubQuestion> deleteById(int id); 
}
