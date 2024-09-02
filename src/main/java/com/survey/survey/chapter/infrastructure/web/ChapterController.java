package com.survey.survey.chapter.infrastructure.web;

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

import com.survey.survey.chapter.application.service.IChapterService;
import com.survey.survey.chapter.domain.entity.Chapter;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/chapters")
public class ChapterController {

    @Autowired
    private IChapterService chapterService;

    // find all
    @GetMapping("/all")
    public ResponseEntity<List<Chapter>> findAll() {
        List<Chapter> chapters = chapterService.findAll();
        return ResponseEntity.ok(chapters);
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable int id) {
        Optional<Chapter> foundChapter = chapterService.findById(id);

        if (!foundChapter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foundChapter.orElseThrow(), HttpStatus.FOUND);
        }
    }

    // ENDPOINT QUE PASANDOLE EL ID DE LA ENCUESTA, ME DEVUELVA UNA LISTA DE CAPITULOS QUE TIENE ESA ENCUESTA
    @GetMapping("/survey/{surveyId}")
    public ResponseEntity<List<Chapter>> getChaptersBySurveyId(@PathVariable int surveyId) {
        List<Chapter> chapters = chapterService.findBySurveyId(surveyId);
        if (chapters.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(chapters);
    }
    
    // find by name
    @GetMapping("/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title) {
        Optional<Chapter> foundChapter = chapterService.findByTitle(title);

        if (!foundChapter.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foundChapter.orElseThrow(), HttpStatus.FOUND);
        }
    }
    
    // create
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Chapter chapter, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }
        Chapter savedChapter = chapterService.save(chapter);
        return new ResponseEntity<>(savedChapter, HttpStatus.CREATED);
    }

    // update by id
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id,@Valid @RequestBody Chapter chapter, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }

        Optional<Chapter> updatedChapter = chapterService.updateById(id, chapter);

        if (!updatedChapter.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chapter not found with id: "+id);
        }

        return ResponseEntity.ok(updatedChapter.get());
    }

    // delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<Chapter> deletedChapter = chapterService.delteById(id);

        if (!deletedChapter.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chapter not found with id: "+id);
        }

        return new ResponseEntity<>(deletedChapter.orElseThrow(), HttpStatus.OK);
    }
    
}
