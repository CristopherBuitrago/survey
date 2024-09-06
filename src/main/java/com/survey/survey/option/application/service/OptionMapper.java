package com.survey.survey.option.application.service;

import com.survey.survey.option.domain.dto.OptionDto;
import com.survey.survey.option.domain.entity.Option;

public class OptionMapper {
    
    public static OptionDto toDto(Option option){
        OptionDto dto = new OptionDto();

        dto.setId(option.getId());
        dto.setOptionText(option.getOptionText());
        dto.setCreatedAt(option.getCreatedAt());
        dto.setUpdatedAt(option.getUpdatedAt());

        return dto;
    }
}
