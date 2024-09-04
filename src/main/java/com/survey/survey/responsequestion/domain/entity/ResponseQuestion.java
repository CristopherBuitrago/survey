package com.survey.survey.responsequestion.domain.entity;

import java.time.LocalDateTime;

import com.survey.survey.option.domain.entity.Option;
import com.survey.survey.question.domain.entity.Question;
import com.survey.survey.subquestion.domain.entity.SubQuestion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="response_question")
public class ResponseQuestion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="option_id", nullable = true)
    private Option option;

    @Column(name = "response_question",columnDefinition = "TEXT", nullable = true)
    private String response;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name="subQuestion_id")
    private SubQuestion subQuestion;

    @Column(columnDefinition="TIMESTAMP", nullable=false, updatable=false)
    private LocalDateTime createdAt;
    
    @Column(columnDefinition="TIMESTAMP", nullable=false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
