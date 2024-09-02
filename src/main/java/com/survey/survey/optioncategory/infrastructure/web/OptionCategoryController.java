package com.survey.survey.optioncategory.infrastructure.web;

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

import com.survey.survey.optioncategory.application.service.IOptionCategoryService;
import com.survey.survey.optioncategory.domain.entity.OptionCategory;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/option-categories")
public class OptionCategoryController {

    @Autowired
    private IOptionCategoryService optionCategoryService;

    // Create a new OptionCategory
    @PostMapping("/create")
    public ResponseEntity<?> createOptionCategory(@Valid @RequestBody OptionCategory optionCategory, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError());
        }
        
        OptionCategory createdOptionCategory = optionCategoryService.save(optionCategory);
        return new ResponseEntity<>(createdOptionCategory, HttpStatus.CREATED);
    }

    // Get all OptionCategories
    @GetMapping("/all")
    public ResponseEntity<List<OptionCategory>> getAllOptionCategories() {
        List<OptionCategory> optionCategories = optionCategoryService.findAll();
        return new ResponseEntity<>(optionCategories, HttpStatus.OK);
    }

    // Get an OptionCategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<OptionCategory> getOptionCategoryById(@PathVariable int id) {
        Optional<OptionCategory> optionCategory = optionCategoryService.findById(id);
        return optionCategory.map(ResponseEntity::ok)
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get an OptionCategory by Name
    @GetMapping("/{name}")
    public ResponseEntity<OptionCategory> getOptionCategoryByName(@PathVariable String name) {
        Optional<OptionCategory> optionCategory = optionCategoryService.findByName(name);
        return optionCategory.map(ResponseEntity::ok)
                             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an OptionCategory by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<OptionCategory> updateOptionCategoryById(@PathVariable int id, @RequestBody OptionCategory optionCategory) {
        Optional<OptionCategory> updatedOptionCategory = optionCategoryService.updateById(id, optionCategory);
        return updatedOptionCategory.map(ResponseEntity::ok)
                                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete an OptionCategory by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOptionCategoryById(@PathVariable int id) {
        Optional<OptionCategory> deletedOptionCategory = optionCategoryService.deleteById(id);
        if (deletedOptionCategory.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
