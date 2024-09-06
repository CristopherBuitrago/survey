package com.survey.survey.optionquestion.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.optionquestion.domain.entity.OptionQuestion;

public interface IOptionQuestionService {
    // get all
    List<OptionQuestion> findAll();
    // get by id
    Optional<OptionQuestion> findById(int id);
    // create
    OptionQuestion create(OptionQuestion optionQuestion);
    //update
    Optional<OptionQuestion> updateById(int id, OptionQuestion optionQuestion);
    //delete
    Optional<OptionQuestion> deleteById(int id);
}
