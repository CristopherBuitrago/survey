package com.survey.survey.option.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.survey.option.domain.entity.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer>{

}
