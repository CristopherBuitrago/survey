package com.survey.survey.chapter.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.chapter.application.service.IChapterService;
import com.survey.survey.chapter.domain.entity.Chapter;

import jakarta.transaction.Transactional;

@Service
public class ChapterAdapter implements IChapterService{
    
    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    @Transactional
    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Override
    @Transactional
    public List<Chapter> findAll() {
        return chapterRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Chapter> findById(int id) {
        Optional<Chapter> foundChapter = chapterRepository.findById(id);

        if (!foundChapter.isPresent()) {
            return Optional.empty();
        } else {
            return foundChapter;
        }
    }

    @Override
    @Transactional
    public List<Chapter> findBySurveyId(int surveyId) {
        return chapterRepository.findBySurveyId(surveyId);
    }

    @Override
    @Transactional
    public Optional<Chapter> findByTitle(String title) {
        Optional<Chapter> foundChapter = chapterRepository.findByTitle(title);

        if (!foundChapter.isPresent()) {
            return Optional.empty();
        } else {
            return foundChapter;
        }
    }

    @Override
    @Transactional
    public Optional<Chapter> updateById(int id, Chapter chapter) {
        Optional<Chapter> foundChapter = chapterRepository.findById(id);

        if (!foundChapter.isPresent()) {
            return Optional.empty();
        } else {
            Chapter updatedChapter = foundChapter.get();

            updatedChapter.setId(id);
            updatedChapter.setComponentHtml(chapter.getComponentHtml());
            updatedChapter.setComponentReact(chapter.getComponentReact());
            updatedChapter.setNumber(chapter.getNumber());
            updatedChapter.setSurvey(chapter.getSurvey());
            updatedChapter.setTitle(chapter.getTitle());

            return Optional.of(chapterRepository.save(updatedChapter));
        }
    }

    @Override
    @Transactional
    public Optional<Chapter> delteById(int id) {
        Optional<Chapter> foundChapter = chapterRepository.findById(id);

        if (!foundChapter.isPresent()) {
            return Optional.empty();
        } else {
            chapterRepository.deleteById(id);
            return foundChapter;
        }
    }


}
