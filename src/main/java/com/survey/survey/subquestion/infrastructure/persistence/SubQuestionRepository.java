package com.survey.survey.subquestion.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.survey.subquestion.domain.entity.SubQuestion;

@Repository
public interface SubQuestionRepository extends  JpaRepository<SubQuestion, Integer> {

}
