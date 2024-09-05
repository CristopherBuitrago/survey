package com.survey.survey.questionresponse.infrastructure.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.questionresponse.application.service.IQuestionResponseService;
import com.survey.survey.questionresponse.domain.entity.QuestionResponse;

import jakarta.transaction.Transactional;

@Service
public class QuestionResponseAdapter implements IQuestionResponseService{

    @Autowired
    private QuestionResponseRepository responseQuestionRepository;

    @Override
    @Transactional
    public QuestionResponse create(QuestionResponse optionQuestion) {
        QuestionResponse savedResponseQuestion = responseQuestionRepository.save(optionQuestion);
        return savedResponseQuestion;
    }

    @Override
    public List<QuestionResponse> findByChapterId(int id) {
        List<QuestionResponse> foundResponse = responseQuestionRepository.findByChapterId(id);
        return foundResponse;
    }

    @Override
    public List<QuestionResponse> findBySurveyId(int id) {
        List<QuestionResponse> foundResponse = responseQuestionRepository.findBySurveyId(id);
        return foundResponse;
    }

    @Override
    public List<QuestionResponse> findByQuestionId(int id) {
        List<QuestionResponse> foundResponse = responseQuestionRepository.findByQuestionId(id);
        return foundResponse;
    }

    @Override
    public List<QuestionResponse> findBySubQuestionId(int id) {
        List<QuestionResponse> foundResponse = responseQuestionRepository.findBySubQuestionId(id);
        return foundResponse;
    }
    
}
