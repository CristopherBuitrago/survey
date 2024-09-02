package com.survey.survey.chapter.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.survey.chapter.domain.entity.Chapter;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer>{
    
    Optional<Chapter> findByTitle(String title);
    List<Chapter> findBySurveyId(int surveyId);
}
