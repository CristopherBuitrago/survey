package com.survey.survey.chapter.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.survey.chapter.domain.entity.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Integer>{
    Optional<Chapter> findByName(String name);
}
