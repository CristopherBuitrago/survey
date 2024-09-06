package com.survey.survey.chapter.application.service;

import java.util.List;
import java.util.Optional;

import com.survey.survey.chapter.domain.entity.Chapter;

public interface IChapterService {
    // crear
    Chapter save(Chapter chapter);
    // leer
    List<Chapter> findAll();
    Optional<Chapter> findById(int id);
    Optional<Chapter> findByTitle(String title);

    List<Chapter> findBySurveyId(int surveyId);
    // actualizar
    Optional<Chapter> updateById(int id, Chapter chapter);
    // eliminar
    Optional<Chapter> delteById(int id);
}
