package com.survey.survey.optioncategory.domain.entity;

import com.survey.survey.categoriescatalog.domain.entity.CategoriesCatalog;
import com.survey.survey.option.domain.entity.Option;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name =  "option_category")
public interface OptionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Option option;
    private CategoriesCatalog categoryOption;
}
