package com.survey.survey.optionquestion.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.optionquestion.application.service.IOptionQuestionService;
import com.survey.survey.optionquestion.domain.entity.OptionQuestion;

import jakarta.transaction.Transactional;

@Service
public class OptionQuestionAdapter implements IOptionQuestionService {

    @Autowired
    private OptionQuestionRepository optionQuestionRepository;

    @Override
    public List<OptionQuestion> findAll() {
        return optionQuestionRepository.findAll();
    }

    @Override
    public Optional<OptionQuestion> findById(int id) {
        Optional<OptionQuestion> foundOptional = optionQuestionRepository.findById(id);

        if (!foundOptional.isPresent()) {
            return Optional.empty();
        } else {
            return foundOptional;
        }
    }

    @Override
    @Transactional
    public OptionQuestion create(OptionQuestion optionQuestion) {
        OptionQuestion savedOptionQuestion = optionQuestionRepository.save(optionQuestion);
        return savedOptionQuestion;
    }

    @Override
    @Transactional
    public Optional<OptionQuestion> updateById(int id, OptionQuestion optionQuestion) {
        Optional<OptionQuestion> foundOptional = optionQuestionRepository.findById(id);

        if (!foundOptional.isPresent()) {
            return Optional.empty();
        } else {
            OptionQuestion updatedOptionQuestion = foundOptional.get();

            updatedOptionQuestion.setId(id);
            updatedOptionQuestion.setOption(optionQuestion.getOption());
            updatedOptionQuestion.setQuestion(optionQuestion.getQuestion());
            updatedOptionQuestion.setSubQuestion(optionQuestion.getSubQuestion());

            return Optional.of(optionQuestionRepository.save(updatedOptionQuestion));
        }
    }

    @Override
    public Optional<OptionQuestion> deleteById(int id) {
        Optional<OptionQuestion> foundOptionQuestion = optionQuestionRepository.findById(id);

        if (!foundOptionQuestion.isPresent()) {
            return Optional.empty();
        } else {
            optionQuestionRepository.deleteById(id);
            return foundOptionQuestion;
        }
    }

}
