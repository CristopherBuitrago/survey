package com.survey.survey.questionresponse.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.survey.survey.questionresponse.domain.entity.QuestionResponse;

public interface QuestionResponseRepository extends JpaRepository<QuestionResponse, Integer>{
    @Query("SELECT qr FROM QuestionResponse qr WHERE qr.question.chapter.id = :chapterId")
    List<QuestionResponse> findByChapterId(@Param("chapterId") int chapterId);

    @Query("SELECT qr FROM QuestionResponse qr WHERE qr.question.chapter.survey.id = :surveyId")
    List<QuestionResponse> findBySurveyId(@Param("surveyId") int surveyId);

    @Query("SELECT qr FROM QuestionResponse qr WHERE qr.question.id = :questionId")
    List<QuestionResponse> findByQuestionId(@Param("questionId") int questionId);

    @Query("SELECT qr FROM QuestionResponse qr WHERE qr.subQuestion.id = :subQuestionId")
    List<QuestionResponse> findBySubQuestionId(@Param("subQuestionId") int subQuestionId);
}
