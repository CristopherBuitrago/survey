package com.survey.survey.questionresponse.application.service;

import java.util.List;

import com.survey.survey.questionresponse.domain.entity.QuestionResponse;

public interface IQuestionResponseService {

    // create response
    QuestionResponse create(QuestionResponse optionQuestion);
    
    // find by chapter id
    List<QuestionResponse> findByChapterId(int id);

    // find by survey id
    List<QuestionResponse> findBySurveyId(int id);

    // find by question id
    List<QuestionResponse> findByQuestionId(int id);

    // find by subquestion id
    List<QuestionResponse> findBySubQuestionId(int id);
}
