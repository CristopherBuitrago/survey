package com.survey.survey.option.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.option.application.service.IOptionService;
import com.survey.survey.option.domain.entity.Option;

import jakarta.transaction.Transactional;

@Service
public class OptionAdapter implements IOptionService{

    @Autowired
    private OptionRepository optionRepository;

    @Override
    @Transactional
    public Option save(Option option) {
        return optionRepository.save(option);
    }

    @Override
    @Transactional
    public Optional<Option> findById(int id) {
        Optional<Option> foundOption = optionRepository.findById(id);

        if (!foundOption.isPresent()) {
            return Optional.empty();
        } else {
            return foundOption;
        }
    }

    @Override
    @Transactional
    public List<Option> findAll() {
        return optionRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Option> update(int id, Option option) {
        Optional<Option> foundOption = optionRepository.findById(id);

        if (!foundOption.isPresent()) {
            Option optionUpdated = foundOption.get();

            optionUpdated.setId(id);
            optionUpdated.setOptionCategory(option.getOptionCategory());
            optionUpdated.setOptionText(option.getOptionText());

            return Optional.of(optionRepository.save(optionUpdated));
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Optional<Option> deleteById(int id) {
        Optional<Option> foundOption = optionRepository.findById(id);

        if (!foundOption.isPresent()) {
            return Optional.empty();
        } else {
            optionRepository.deleteById(id);
            return foundOption;
        }
    }
    
}
