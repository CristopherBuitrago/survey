package com.survey.survey.questioncategory.infrastructure.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.survey.questioncategory.application.service.IQuestionCategoryService;
import com.survey.survey.questioncategory.domain.entity.QuestionCategory;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/question-category")
public class QuestionCategoryController {

    @Autowired
    private IQuestionCategoryService questionCategoryService;

    // get all question categories by id
    @GetMapping("/all")
    public ResponseEntity<List<QuestionCategory>> findAll() {
        List<QuestionCategory> questionCategories = questionCategoryService.findAll();
        return ResponseEntity.ok(questionCategories);
    }

    // get question category by id
    @GetMapping("/id/{id}")
    public ResponseEntity<QuestionCategory> findById(@PathVariable int id) {
        Optional<QuestionCategory> foundQuesCategory = questionCategoryService.findById(id);
        return foundQuesCategory.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // create
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody QuestionCategory questionCategory, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        } else {
            QuestionCategory savedQuestionCategory = questionCategoryService.save(questionCategory);
            return new ResponseEntity<>(savedQuestionCategory, HttpStatus.CREATED);
        }
    }
    
}
