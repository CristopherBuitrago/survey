package com.survey.survey.chapter.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.survey.survey.question.domain.entity.Question;
import com.survey.survey.survey.domain.entity.Survey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chapters")
@NoArgsConstructor
@Getter
@Setter
public class Chapter {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private int id;

    @Column(nullable=false)
    @NotNull(message="The field cannot be null!")
    private int number;

    @Column
    @NotBlank(message="The field cannot be blank!")
    private String title;
    
    @ManyToOne
    @JoinColumn(name="survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "chapter")
    private List<Question> questions;

    @Column
    private String componentHtml;

    @Column
    private String componentReact;
    
    @Column(columnDefinition="TIMESTAMP", nullable=false)
    private LocalDateTime createdAt;
    
    @Column(columnDefinition="TIMESTAMP", nullable=false)
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
