package com.survey.survey.questionresponse.domain.entity;

import java.time.LocalDateTime;

import com.survey.survey.option.domain.entity.Option;
import com.survey.survey.question.domain.entity.Question;
import com.survey.survey.subquestion.domain.entity.SubQuestion;

import jakarta.persistence.Entity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="response_question")
@Data
public class QuestionResponse {
    private int id;
    private Question question;
    private SubQuestion subQuestion;
    private Option choosedOption;
    private String response;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PostPersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
