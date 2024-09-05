package com.survey.survey.chapterresponse.domain.entity;

import java.util.List;

import com.survey.survey.questionresponse.domain.entity.QuestionResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="chapter_response")
@Data
public class ChapterResponse {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column
    private int surveyId;

    @Column
    private String chapterTitle;

    @Column
    private int chapterNumber;

    @OneToMany(mappedBy="chapterContainer")
    private List<QuestionResponse> responses;
}
