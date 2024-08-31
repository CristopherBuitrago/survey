package com.survey.survey.survey.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.survey.application.service.ISurveyService;
import com.survey.survey.survey.domain.entity.Survey;

import jakarta.transaction.Transactional;

@Service
public class SurveyAdapter implements ISurveyService{

    @Autowired
    private SurveyRepository surveyRepository;

    // create
    @Override
    @Transactional
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    // update
    @Override
    @Transactional
    public Optional<Survey> update(int id, Survey survey) {
        Optional<Survey> existingSurveyOptional = surveyRepository.findById(id);

        if (existingSurveyOptional.isPresent()) {
            Survey existingSurvey = existingSurveyOptional.get();
            // updating necessary fields
            existingSurvey.setId(id);
            existingSurvey.setName(survey.getName());
            existingSurvey.setDescription(survey.getDescription());
            existingSurvey.setCategories(survey.getCategories());
            existingSurvey.setComponentHtml(survey.getComponentHtml());
            existingSurvey.setComponentReact(survey.getComponentReact());
            // save the changes
            return Optional.of(surveyRepository.save(existingSurvey));

        } else {
            return Optional.empty();
        }
    }   

    // delete by id
    @Override
    @Transactional
    public Optional<Survey> deleteById(int id) {
        Optional<Survey> existingSurveyOptional = surveyRepository.findById(id);

        if (existingSurveyOptional.isPresent()) {
            surveyRepository.deleteById(id);
            return existingSurveyOptional;
        } else {
            return Optional.empty();
        }
    }

    // find all
    @Override
    @Transactional
    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    // find by id
    @Override
    @Transactional
    public Optional<Survey> findById(int id) {
        Optional<Survey> existingSurveyOptional = surveyRepository.findById(id);

        if (existingSurveyOptional.isPresent()) {
            return existingSurveyOptional;
        } else {
            return Optional.empty();
        }
        
    }
    
}
