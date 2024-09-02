package com.survey.survey.question.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.question.application.service.IQuestionService;
import com.survey.survey.question.domain.entity.Question;

import jakarta.transaction.Transactional;

@Service
public class QuestionAdapter implements IQuestionService{

    @Autowired
    private QuestionRepositry questionRepository;

    @Override
    @Transactional
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    @Transactional
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Question> findById(int id) {
        Optional<Question> foundQuestion = questionRepository.findById(id);

        if (!foundQuestion.isPresent()) {
            return Optional.empty();
        } else {
            return foundQuestion;
        }
    }

    @Override
    @Transactional
    public Optional<Question> updateById(int id, Question question) {
        Optional<Question> foundQuestion = questionRepository.findById(id);

        if (!foundQuestion.isPresent()) {
            return Optional.empty();
        } else {
            Question updatedQuestion = foundQuestion.get();

            updatedQuestion.setId(id);
            updatedQuestion.setQuestionNumber(question.getQuestionNumber());
            updatedQuestion.setQuestionText(question.getQuestionNumber());
            updatedQuestion.setResponseType(question.getResponseType());
            updatedQuestion.setCommentQuestion(question.getCommentQuestion());

            
            return Optional.of(questionRepository.save(updatedQuestion));
        }
    }

    @Override
    @Transactional
    public Optional<Question> deleteById(int id) {
        Optional<Question> foundQuestion = questionRepository.findById(id);

        if (!foundQuestion.isPresent()) {
            return Optional.empty();
        } else {
            questionRepository.deleteById(id);
            return foundQuestion;
        }
    }

    @Override
    public List<Question> findByChapterId(int chapterId) {
        return questionRepository.findByChapterId(chapterId);
    }

}
