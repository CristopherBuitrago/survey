package com.survey.survey.subquestion.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.subquestion.application.service.ISubQuestionService;
import com.survey.survey.subquestion.domain.entity.SubQuestion;

import jakarta.transaction.Transactional;

@Service
public class SubQuestionAdapter implements ISubQuestionService{

    @Autowired
    private SubQuestionRepository subQuestionRepository;

    @Override
    public Optional<List<SubQuestion>> findAll() {
        Optional<List<SubQuestion>> foundSubQuestions = Optional.ofNullable(subQuestionRepository.findAll());

        if(!foundSubQuestions.isPresent()) {
            return Optional.empty();
        }

        return foundSubQuestions;
    }

    @Override
    public Optional<SubQuestion> findById(int id) {
        Optional<SubQuestion> foundSubQuestion = subQuestionRepository.findById(id);

        if (!foundSubQuestion.isPresent()) {
            return Optional.empty();
        }

        return foundSubQuestion;
    }

    @Override
    @Transactional
    public SubQuestion save(SubQuestion subQuestion) {
        subQuestionRepository.save(subQuestion);
        return subQuestion;
    }

    @Override
    @Transactional
    public Optional<SubQuestion> updateById(int id, SubQuestion subQuestion) {
        Optional<SubQuestion> foundSubQuestion = subQuestionRepository.findById(id);

        if (!foundSubQuestion.isPresent()) {
            return Optional.empty();
        }

        SubQuestion updatedSubQuestion = foundSubQuestion.get();

        updatedSubQuestion.setId(id);
        updatedSubQuestion.setQuestion(subQuestion.getQuestion());
        updatedSubQuestion.setSubquestionText(subQuestion.getSubquestionText());

        return Optional.of(subQuestionRepository.save(updatedSubQuestion));
    }

    @Override
    @Transactional
    public Optional<SubQuestion> deleteById(int id) {
        Optional<SubQuestion> foundSubQuestion = subQuestionRepository.findById(id);

        if (!foundSubQuestion.isPresent()) {
            return Optional.empty();
        } else {
            subQuestionRepository.deleteById(id);
            return foundSubQuestion;
        }
    }
}
