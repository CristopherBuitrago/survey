package com.survey.survey.questionresponse.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.survey.survey.chapterresponse.domain.entity.ChapterResponse;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="response_question")
@Data
public class QuestionResponse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name="subquestion_id")
    private SubQuestion subQuestion;

    @ManyToOne
    @JoinColumn(name="chapter_id")
    private ChapterResponse chapterContainer; 

    @OneToMany(mappedBy="responses")
    private List<Option> choosedOptions;

    @Column(columnDefinition="text")
    private String response;

    @Column(columnDefinition="timestamp", nullable=false, updatable=false)
    private LocalDateTime createdAt;

    @Column(columnDefinition="timestamp", nullable=false)
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
