package com.survey.survey.question.application.service;

import com.survey.survey.question.domain.dto.QuestionDto;
import com.survey.survey.question.domain.entity.Question;

public class QuestionMapper {
    public static QuestionDto toDto(Question question) {
        QuestionDto dto = new QuestionDto();
        dto.setId(question.getId());
        dto.setQuestionNumber(question.getQuestionNumber());
        dto.setQuestionText(question.getQuestionText());
        dto.setResponsetype(question.getResponseType());
        dto.setCommentQuestion(question.getCommentQuestion());
        dto.setCreatedAt(question.getCreatedAt());
        dto.setUpdatedAt(question.getUpdatedAt());
        return dto;
    }
}
