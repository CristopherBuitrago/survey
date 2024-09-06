package com.survey.survey.subquestion.infrastructure.web;

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

import com.survey.survey.subquestion.application.service.ISubQuestionService;
import com.survey.survey.subquestion.domain.entity.SubQuestion;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/sub-question")
public class SubQuestionController {
    @Autowired
    private ISubQuestionService subQuestionService;

    // get all
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        Optional<List<SubQuestion>> foundSubQuestions = subQuestionService.findAll();

        if (!foundSubQuestions.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Not sub questions found!");
        } else {
            return ResponseEntity.ok(foundSubQuestions);
        }
    }
    
    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<SubQuestion> foundSubQuestion = subQuestionService.findById(id);

        if (!foundSubQuestion.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found sub question with id: "+id);
        } else {
            return new ResponseEntity<>(foundSubQuestion.orElseThrow(), HttpStatus.FOUND);
        }
    }

    // create
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody SubQuestion subQuestion, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        SubQuestion savedSubQuestion = subQuestionService.save(subQuestion);
        return new ResponseEntity<>(savedSubQuestion, HttpStatus.CREATED);
    }
    
    // update by id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @Valid @RequestBody SubQuestion subQuestion, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        Optional<SubQuestion> updatedQuestion = subQuestionService.updateById(id, subQuestion);

        if (!updatedQuestion.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Sub Question found with id: "+id);
        }

        return ResponseEntity.ok(updatedQuestion);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<SubQuestion> deletedSubQuestion = subQuestionService.deleteById(id);

        if (!deletedSubQuestion.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not sub question found with id: "+id);
        } else {
            return ResponseEntity.ok(deletedSubQuestion);
        }

    }
    
}
