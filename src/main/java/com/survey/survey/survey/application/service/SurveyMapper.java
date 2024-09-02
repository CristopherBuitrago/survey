package com.survey.survey.survey.application.service;

import com.survey.survey.survey.domain.dto.SurveyDto;
import com.survey.survey.survey.domain.entity.Survey;

public class SurveyMapper {

    public static SurveyDto toDto(Survey survey) {
        SurveyDto dto = new SurveyDto();
        dto.setId(survey.getId());
        dto.setName(survey.getName());
        dto.setDescription(survey.getDescription());
        dto.setComponentHtml(survey.getComponentHtml());
        dto.setComponentReact(survey.getComponentReact());
        dto.setStatus(survey.getStatus());
        return dto;
    }
}
