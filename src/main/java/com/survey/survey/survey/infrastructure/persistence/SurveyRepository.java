package com.survey.survey.survey.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.survey.survey.domain.entity.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Integer>{

}
