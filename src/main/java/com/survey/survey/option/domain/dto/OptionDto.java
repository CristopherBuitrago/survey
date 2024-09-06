package com.survey.survey.option.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OptionDto {
    private int id;
    private String optionText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
