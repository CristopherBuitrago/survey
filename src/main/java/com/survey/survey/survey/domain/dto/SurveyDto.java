package com.survey.survey.survey.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SurveyDto {
    private int id;
    private String name;
    private String description;
    private String componentHtml;
    private String componentReact;
    private Boolean status;
}
