package com.survey.survey.chapter.application.service;

import com.survey.survey.chapter.domain.dto.ChapterDto;
import com.survey.survey.chapter.domain.entity.Chapter;

public class ChapterMapper {
    public static ChapterDto toDto(Chapter chapter) {
        ChapterDto dto = new ChapterDto();
        dto.setId(chapter.getId());
        dto.setNumber(chapter.getNumber());
        dto.setTitle(chapter.getTitle());
        dto.setComponentHtml(chapter.getComponentHtml());
        dto.setComponentreact(chapter.getComponentReact());
        dto.setCreatedAt(chapter.getCreatedAt());
        dto.setUpdatedAt(chapter.getUpdatedAt());
        return dto;
    }
}
