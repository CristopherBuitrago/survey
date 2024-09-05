package com.survey.survey.questionresponse.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.survey.questionresponse.application.service.IQuestionResponseService;
import com.survey.survey.questionresponse.domain.entity.QuestionResponse;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/response-question")
public class QuestionResponseController {

    @Autowired
    private IQuestionResponseService responseService;

    // create
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody QuestionResponse responseQuestion, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        QuestionResponse createdResponse = responseService.create(responseQuestion);
        return ResponseEntity.ok(createdResponse);
    }

    // find by survey id
    @GetMapping("/survey/{id}")
    public ResponseEntity<List<QuestionResponse>> findBySurveyId(@PathVariable int id) {
        List<QuestionResponse> foundResponses = responseService.findBySurveyId(id);
        return ResponseEntity.ok(foundResponses);
    }
    
    // find by chapter id
    @GetMapping("/chapter/{id}")
    public ResponseEntity<List<QuestionResponse>> findByChapterId(@PathVariable int id) {
        List<QuestionResponse> foundResponses = responseService.findByChapterId(id);
        return ResponseEntity.ok(foundResponses);
    }

    // find by question id
    @GetMapping("/question/{id}")
    public ResponseEntity<List<QuestionResponse>> findByQuestionId(@PathVariable int id) {
        List<QuestionResponse> foundResponse = responseService.findByQuestionId(id);
        return ResponseEntity.ok(foundResponse);
    }
    
    
}
