package com.survey.survey.subquestion.domain.entity;

import java.time.LocalDateTime;

import com.survey.survey.question.domain.entity.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="sub_questions")
public class SubQuestion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @Column
    private String subquestionText;

    @Column(columnDefinition="TIMESTAMP", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @Column(columnDefinition="TIMESTAMP", nullable=false, updatable=false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PostPersist
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
