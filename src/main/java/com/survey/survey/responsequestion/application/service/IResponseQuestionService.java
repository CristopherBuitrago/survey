package com.survey.survey.responsequestion.application.service;

import java.util.List;

import com.survey.survey.responsequestion.domain.entity.ResponseQuestion;

public interface IResponseQuestionService {

    // create response
    ResponseQuestion create(ResponseQuestion optionQuestion);
    
    // find by chapter id
    List<ResponseQuestion> findByChapterId(int id);

    // find by survey id
    List<ResponseQuestion> findBySurveyId(int id);

    // find by question id
    List<ResponseQuestion> findByQuestionId(int id);

    // find by subquestion id
    List<ResponseQuestion> findBySubQuestionId(int id);
}
