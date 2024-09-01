package com.survey.survey.categoriescatalog.infrastructure.web;

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

import com.survey.survey.categoriescatalog.application.service.ICategoryCatalogService;
import com.survey.survey.categoriescatalog.domain.entity.CategoriesCatalog;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/categories-catalog")
public class CategoryCatalogController {

    @Autowired
    private ICategoryCatalogService catalogService;

    // save
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody CategoriesCatalog categoriesCatalog, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.hasFieldErrors());
        }

        CategoriesCatalog savedCategory = catalogService.save(categoriesCatalog);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    
    // get methods
    @GetMapping("/all")
    public ResponseEntity<List<CategoriesCatalog>> findAll() {
        List<CategoriesCatalog> categories = catalogService.findAll();
        return ResponseEntity.ok(categories);
    }

    // find by name
    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Optional<CategoriesCatalog> foundCatalog = catalogService.findByName(name);

        if (!foundCatalog.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Catalog not found with name: "+ name);
        } else {
            return new ResponseEntity<>(foundCatalog.orElseThrow(), HttpStatus.FOUND);
        }
        
    }
    
    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<CategoriesCatalog> foundCatalog = catalogService.findById(id);

        if (!foundCatalog.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Catalog not found with id: "+ id);
        } else {
            return new ResponseEntity<>(foundCatalog.orElseThrow(), HttpStatus.FOUND);
        }
        
    }

    // update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable int id, @Valid @RequestBody CategoriesCatalog categoriesCatalog, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldErrors());
        }

        Optional<CategoriesCatalog> updatedCategory = catalogService.updateById(id, categoriesCatalog);

        if (!updatedCategory.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with id: "+id);
        } else {
            return new ResponseEntity<>(updatedCategory.orElseThrow(), HttpStatus.OK);
        }
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        Optional<CategoriesCatalog> deletedCategory = catalogService.deleteById(id);

        if (!deletedCategory.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with id: "+id);
        } else {
            return new ResponseEntity<>(deletedCategory.orElseThrow(), HttpStatus.OK);
        }
    }
}
