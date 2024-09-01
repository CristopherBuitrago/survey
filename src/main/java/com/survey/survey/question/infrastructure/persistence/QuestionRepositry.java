package com.survey.survey.question.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.survey.question.domain.entity.Question;

@Repository
public interface QuestionRepositry extends JpaRepository<Question, Integer>{
    
}
