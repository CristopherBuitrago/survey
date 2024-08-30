package com.survey.survey.survey.infrastructure.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.survey.survey.application.service.ISurveyService;
import com.survey.survey.survey.domain.entity.Survey;





@RestController
@RequestMapping("/survey")
public class SurveyController {
    
    // using survey service to use the methods that it ha
    @Autowired
    private ISurveyService surveyService;

    //find all
    @GetMapping
    public List<Survey> findAll() {
        /*
        * using the service to find all,
        * remember that surveyService allow us 
        * navigate into other classes that implements 
        * IUserService like for example SurveyAdapter 
        */
        return surveyService.findAll();
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
    
    
    // save (without validation for now)
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Survey survey) {
        // save the survey into db
        surveyService.save(survey);
        // set successful message
        return new ResponseEntity<>(survey, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSurvey(@PathVariable Integer id, @RequestBody Survey updatedSurvey) {
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
