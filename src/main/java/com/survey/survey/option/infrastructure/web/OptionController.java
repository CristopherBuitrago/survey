package com.survey.survey.option.infrastructure.web;

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

import com.survey.survey.option.application.service.IOptionService;
import com.survey.survey.option.domain.entity.Option;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/options")
public class OptionController {

    @Autowired
    private IOptionService optionService;

    // Crear una nueva opción
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody Option option, BindingResult result) {
        // Validar si hay errores en el BindingResult
        if (result.hasErrors()) {
            // Si hay errores, retornar una respuesta de Bad Request con los errores
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }
        // Si no hay errores, guardar la opción y retornar una respuesta con el objeto creado
        Option savedOption = optionService.save(option);
        return new ResponseEntity<>(savedOption, HttpStatus.CREATED);
    }

    // Obtener una opción por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        // Buscar la opción por ID
        Optional<Option> option = optionService.findById(id);

        // Si no se encuentra, retornar una respuesta de Not Found
        if (!option.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Option not found with id: " + id);
        }

        // Si se encuentra, retornar la opción en la respuesta
        return ResponseEntity.ok(option.get());
    }

    // Obtener todas las opciones
    @GetMapping("/all")
    public ResponseEntity<List<Option>> findAll() {
        // Obtener todas las opciones y retornarlas en la respuesta
        List<Option> options = optionService.findAll();
        return ResponseEntity.ok(options);
    }

    // Actualizar una opción por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @Valid @RequestBody Option option, BindingResult result) {
        // Validar si hay errores en el BindingResult
        if (result.hasErrors()) {
            // Si hay errores, retornar una respuesta de Bad Request con los errores
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        // Intentar actualizar la opción
        Optional<Option> updatedOption = optionService.update(id, option);

        // Si la opción no se encuentra, retornar una respuesta de Not Found
        if (!updatedOption.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Option not found with id: " + id);
        }

        // Si se actualiza con éxito, retornar la opción actualizada en la respuesta
        return new ResponseEntity<>(updatedOption.orElseThrow(), HttpStatus.OK);
    }

    // Eliminar una opción por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        // Intentar eliminar la opción por ID
        Optional<Option> deletedOption = optionService.deleteById(id);

        // Si la opción no se encuentra, retornar una respuesta de Not Found
        if (!deletedOption.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Option not found with id: " + id);
        }

        // Si se elimina con éxito, retornar una respuesta de No Content
        return new ResponseEntity<>(deletedOption.orElseThrow(), HttpStatus.OK);
    }

    // obtener options por id de la pregunta
    @GetMapping("/question/{id}")
    public ResponseEntity<List<Option>> findByQuestionId(@PathVariable int id) {
        List<Option> foundOptions = optionService.findByQuestionId(id);
        return ResponseEntity.ok(foundOptions);
    }
    
}
