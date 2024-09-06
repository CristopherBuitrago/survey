package com.survey.survey.question.infrastructure.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.survey.survey.question.application.service.IQuestionService;
import com.survey.survey.question.application.service.QuestionMapper;
import com.survey.survey.question.domain.dto.QuestionDto;
import com.survey.survey.question.domain.entity.Question;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    // read get methods
    @GetMapping("/all")
    public ResponseEntity<List<Question>> findAll() {
        List<Question> questionList = questionService.findAll();
        return ResponseEntity.ok(questionList);
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Question> foundQuestion = questionService.findById(id);

        if (!foundQuestion.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found with id: " + id);
        } else {
            return new ResponseEntity<>(foundQuestion.orElseThrow(), HttpStatus.FOUND);
        }
    }

    // NECESITO UN ENDPOINT QUE PASANDOLE EL ID DE EL CAPITULO, ME DEVUELVA UNA
    // LISTA DE PREGUNTAS QUE TIENE ESE CAPITULO
    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByChapterId(@PathVariable int chapterId) {
        List<QuestionDto> questions = questionService.findByChapterId(chapterId).stream()
                .map(QuestionMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // create
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Question question, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        Question savedQuestion = questionService.save(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @Valid @RequestBody Question question,
            BindingResult result) {
        // Verifica si hay errores de validación
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        // Busca la pregunta existente por ID
        Optional<Question> existingQuestionOp = questionService.findById(id);

        // Si la pregunta no existe, retorna un error 404
        if (!existingQuestionOp.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found with id " + id);
        }

        // Obtiene la pregunta existente
        Question existingQuestion = existingQuestionOp.get();

        // Actualiza los campos de la pregunta

        existingQuestion.setQuestionNumber(question.getQuestionNumber());
        existingQuestion.setResponseType(existingQuestion.getResponseType());
        existingQuestion.setCommentQuestion(question.getCommentQuestion());
        existingQuestion.setQuestionText(question.getQuestionText());

        // Guarda y retorna la pregunta actualizada
        return ResponseEntity.ok(questionService.save(existingQuestion));
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        Optional<Question> deletedQuestion = questionService.deleteById(id);

        if (!deletedQuestion.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found with id: " + id);
        } else {
            return new ResponseEntity<>(deletedQuestion.orElseThrow(), HttpStatus.OK);
        }
    }

}
