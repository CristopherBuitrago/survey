package com.survey.survey.survey.infrastructure.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.survey.survey.application.service.ISurveyService;
import com.survey.survey.survey.application.service.SurveyMapper;
import com.survey.survey.survey.domain.dto.SurveyDto;
import com.survey.survey.survey.domain.entity.Survey;

import jakarta.validation.Valid;





@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = "http://localhost:5173")
public class SurveyController {
    
    // using survey service to use the methods that it ha
    @Autowired
    private ISurveyService surveyService;

    //find all
    @GetMapping("/all")
    public ResponseEntity<List<SurveyDto>> findAll() {
        List<SurveyDto> surveys = surveyService.findAll().stream()
                .map(SurveyMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/all/public")
    public ResponseEntity<List<Survey>> findAllPublics() {
        List<Survey> surveys = surveyService.findAllPublic();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        // find the survey by id
        Optional<Survey> foundSurvey = surveyService.findById(id);
        // verify if was find
        if (!foundSurvey.isPresent()) {
            // return an status not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // return the survey
            return new ResponseEntity<>(foundSurvey.orElseThrow(), HttpStatus.OK);
        }
    }
    
    
    // save
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Survey survey, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        Survey savedSurvey = surveyService.save(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSurvey(@PathVariable Integer id,@Valid @RequestBody Survey updatedSurvey, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }
        // first we need to find the survey
        Optional<Survey> foundSurvey = surveyService.findById(id);

        // verify if was found
        if (!foundSurvey.isPresent()) {
            // throw not found message
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // update survey
        updatedSurvey.setId(id);
        // save update
        surveyService.save(updatedSurvey);
        // return successful message and the survey modified
        return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
    }
    
}
