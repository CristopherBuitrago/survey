package com.survey.survey.question.domain.entity;

import java.time.LocalDateTime;

import com.survey.survey.chapter.domain.entity.Chapter;

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
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="questions")
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;

    @Column(nullable=false)
    @NotBlank(message="The field cannot be blank!")
    private String questionNumber;

    @Column(nullable=false)
    private String responseType;

    @Column(nullable=false)
    @NotBlank(message="The field cannot be blank!")
    private String commentQuestion;

    @Column(nullable=false)
    @NotBlank(message="The field cannot be blank!")
    private String questionText;
    
    @Column(columnDefinition="TIMESTAMP", nullable=false, updatable=false)
    private LocalDateTime createdAt;
    
    @Column(columnDefinition="TIMESTAMP", nullable=false, updatable=false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

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
