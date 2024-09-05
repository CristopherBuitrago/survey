package com.survey.survey.option.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.survey.survey.option.domain.entity.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer>{
    @Query("SELECT o FROM Option o WHERE o.question.id = :questionId")
    List<Option> findByQuestionId(@Param("questionId") int questionId); 
}
