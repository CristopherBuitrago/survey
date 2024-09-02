package com.survey.survey.optionquestion.infrastructure.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.survey.optionquestion.application.service.IOptionQuestionService;
import com.survey.survey.optionquestion.domain.entity.OptionQuestion;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/option-question")
public class OptionQuestionController {

    @Autowired
    private IOptionQuestionService optionQuestionService;

    // get all
    @GetMapping("/all")
    public ResponseEntity<List<OptionQuestion>> findAll () {
        List<OptionQuestion> optionQuestions = optionQuestionService.findAll();
        return new ResponseEntity<>(optionQuestions, HttpStatus.OK);
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<OptionQuestion> findById(@PathVariable int id) {
        Optional<OptionQuestion> foundOptionQuestion = optionQuestionService.findById(id);
        return foundOptionQuestion.map(ResponseEntity::ok)
                                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // create
    @PostMapping("path")
    public ResponseEntity<?> create(@Valid @RequestBody OptionQuestion optionQuestion, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        OptionQuestion createdOptionQuestion = optionQuestionService.create(optionQuestion);
        return new ResponseEntity<>(createdOptionQuestion, HttpStatus.CREATED);
    }
    
    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @Valid @RequestBody OptionQuestion optionQuestion, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        Optional<OptionQuestion> updatedOptionQuestion = optionQuestionService.updateById(id, optionQuestion);
        return updatedOptionQuestion.map(ResponseEntity::ok)
                                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OptionQuestion> deleteById(@PathVariable int id) {
        
        Optional<OptionQuestion> deletedQuestion = optionQuestionService.deleteById(id);
        return deletedQuestion.map(ResponseEntity::ok)
                              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
