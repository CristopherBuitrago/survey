package com.survey.survey.responsequestion.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.survey.survey.responsequestion.domain.entity.ResponseQuestion;

public interface ResponseQuestionRepository extends JpaRepository<ResponseQuestion, Integer>{
    @Query("SELECT rq FROM response_question rq WHERE rq.question.chapter.id = :chapterId")
    List<ResponseQuestion> findByChapterId(@Param("chapterId") int chapterId);

    @Query("SELECT rq FROM response_question rq WHERE rq.question.chapter.survey.id = :surveyId")
    List<ResponseQuestion> findBySurveyId(@Param("surveyId") int surveyId);

    @Query("SELECT rq FROM response_question rq WHERE rq.question.id = :questionId")
    List<ResponseQuestion> findByQuestionId(@Param("questionId") int questionId);

    @Query("SELECT rq FROM response_question rq WHERE rq.subQuestion.id = :subQuestionId")
    List<ResponseQuestion> findBySubQuestionId(@Param("subQuestionId") int subQuestionId);
}
