package com.survey.survey.chapterresponse.application.service;

import java.util.List;

import com.survey.survey.chapterresponse.domain.entity.ChapterResponse;

public interface ChapterResponseService {
    List<ChapterResponse> findById(int id);
}
