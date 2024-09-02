package com.survey.survey.chapter.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChapterDto {
    private int id;
    private int number;
    private String title;
    private String componentHtml;
    private String componentreact;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
