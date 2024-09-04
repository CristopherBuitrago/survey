package com.survey.survey.responsequestion.infrastructure.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.responsequestion.application.service.IResponseQuestionService;
import com.survey.survey.responsequestion.domain.entity.ResponseQuestion;

import jakarta.transaction.Transactional;

@Service
public class ResponseQuestionAdapter implements IResponseQuestionService{

    @Autowired
    private ResponseQuestionRepository responseQuestionRepository;

    @Override
    @Transactional
    public ResponseQuestion create(ResponseQuestion optionQuestion) {
        ResponseQuestion savedResponseQuestion = responseQuestionRepository.save(optionQuestion);
        return savedResponseQuestion;
    }

    @Override
    public List<ResponseQuestion> findByChapterId(int id) {
        List<ResponseQuestion> foundResponse = responseQuestionRepository.findByChapterId(id);
        return foundResponse;
    }

    @Override
    public List<ResponseQuestion> findBySurveyId(int id) {
        List<ResponseQuestion> foundResponse = responseQuestionRepository.findBySurveyId(id);
        return foundResponse;
    }

    @Override
    public List<ResponseQuestion> findByQuestionId(int id) {
        List<ResponseQuestion> foundResponse = responseQuestionRepository.findByQuestionId(id);
        return foundResponse;
    }

    @Override
    public List<ResponseQuestion> findBySubQuestionId(int id) {
        List<ResponseQuestion> foundResponse = responseQuestionRepository.findBySubQuestionId(id);
        return foundResponse;
    }
    
}
