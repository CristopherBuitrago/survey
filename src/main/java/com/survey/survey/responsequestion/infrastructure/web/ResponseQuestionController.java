package com.survey.survey.responsequestion.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.survey.responsequestion.application.service.IResponseQuestionService;
import com.survey.survey.responsequestion.domain.entity.ResponseQuestion;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/response-question")
public class ResponseQuestionController {

    @Autowired
    private IResponseQuestionService responseService;


    // create
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody ResponseQuestion responseQuestion, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        ResponseQuestion createdResponse = responseService.create(responseQuestion);
        return ResponseEntity.ok(createdResponse);
    }

    // find by survey id
    @GetMapping("/survey/{id}")
    public ResponseEntity<List<ResponseQuestion>> findBySurveyId(@PathVariable int id) {
        List<ResponseQuestion> foundResponses = responseService.findBySurveyId(id);
        return ResponseEntity.ok(foundResponses);
    }
    
    // find by chapter id
    @GetMapping("/chapter/{id}")
    public ResponseEntity<List<ResponseQuestion>> findByChapterId(@PathVariable int id) {
        List<ResponseQuestion> foundResponses = responseService.findByChapterId(id);
        return ResponseEntity.ok(foundResponses);
    }

    // find by question id
    @GetMapping("/question/{id}")
    public ResponseEntity<List<ResponseQuestion>> findByQuestionId(@PathVariable int id) {
        List<ResponseQuestion> foundResponse = responseService.findByQuestionId(id);
        return ResponseEntity.ok(foundResponse);
    }
    
    
}
