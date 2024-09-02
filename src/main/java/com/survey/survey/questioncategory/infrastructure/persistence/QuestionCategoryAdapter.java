package com.survey.survey.questioncategory.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.survey.questioncategory.application.service.IQuestionCategoryService;
import com.survey.survey.questioncategory.domain.entity.QuestionCategory;

import jakarta.transaction.Transactional;

@Service
public class QuestionCategoryAdapter implements IQuestionCategoryService {

    @Autowired
    private QuestionCategoryRepository questionCategoryRepo;

    @Override
    public List<QuestionCategory> findAll() {
        return questionCategoryRepo.findAll();
    }

    @Override
    public Optional<QuestionCategory> findById(int id) {
        Optional<QuestionCategory> foundQueOptional = questionCategoryRepo.findById(id);
        
        if (!foundQueOptional.isPresent()) {
            return Optional.empty();
        } else {
            return foundQueOptional;
        }
    }

    @Override
    @Transactional
    public QuestionCategory save(QuestionCategory questionCategory) {
        QuestionCategory savedQuestionCategory = questionCategoryRepo.save(questionCategory);
        return savedQuestionCategory;
    }

    @Override
    @Transactional
    public Optional<QuestionCategory> updateById(int id, QuestionCategory questionCategory) {
        Optional<QuestionCategory> foundQuesOptional = questionCategoryRepo.findById(id);

        if (!foundQuesOptional.isPresent()) {
            return Optional.empty();
        } else {
            QuestionCategory updatedQueCategory = foundQuesOptional.get();

            updatedQueCategory.setId(id);
            updatedQueCategory.setOptionCategory(questionCategory.getOptionCategory());
            updatedQueCategory.setQuestion(questionCategory.getQuestion());

            return Optional.of(questionCategoryRepo.save(updatedQueCategory));
        }
    }

    @Override
    public Optional<QuestionCategory> deleteById(int id) {
        Optional<QuestionCategory> foundQuesCategory = questionCategoryRepo.findById(id);

        if(!foundQuesCategory.isPresent()) {
            return Optional.empty();
        } else {
            questionCategoryRepo.deleteById(id);
            return foundQuesCategory;
        }
    }

}
