package com.survey.survey.question.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class QuestionDto {
    private int id;
    private String questionNumber;
    private String responsetype;
    private String commentQuestion;
    private String questionText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
