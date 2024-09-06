package com.survey.survey.question.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.question.domain.entity.Question;

public interface IQuestionService {
    // create
    Question save(Question question);
    // read
    List<Question> findAll();
    Optional<Question> findById(int id);

    List<Question> findByChapterId(int chapterId);
    // update
    Optional<Question> updateById(int id, Question question);
    // delete
    Optional<Question> deleteById(int id);
}
