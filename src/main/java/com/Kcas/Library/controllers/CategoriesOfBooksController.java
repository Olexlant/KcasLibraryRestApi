package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.CategoriesOfBooks;
import com.Kcas.Library.services.CategoriesOfBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories-of-books")
public class CategoriesOfBooksController {
    private final CategoriesOfBooksService categoriesOfBooksService;

    @Autowired
    public CategoriesOfBooksController(CategoriesOfBooksService categoriesOfBooksService) {
        this.categoriesOfBooksService = categoriesOfBooksService;
    }

    @GetMapping
    public List<CategoriesOfBooks> getAllCategoriesOfBooks() {
        return categoriesOfBooksService.getAllCategoriesOfBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriesOfBooks> getCategoriesOfBooksById(@PathVariable Long id) {
        Optional<CategoriesOfBooks> categoriesOfBooks = categoriesOfBooksService.getCategoriesOfBooksById(id);
        return categoriesOfBooks.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriesOfBooks> createCategoriesOfBooks(@RequestBody CategoriesOfBooks categoriesOfBooks) {
        CategoriesOfBooks savedCategoriesOfBooks = categoriesOfBooksService.saveCategoriesOfBooks(categoriesOfBooks);
        return new ResponseEntity<>(savedCategoriesOfBooks, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriesOfBooks> updateCategoriesOfBooks(@PathVariable Long id, @RequestBody CategoriesOfBooks categoriesOfBooks) {
        if (categoriesOfBooksService.getCategoriesOfBooksById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoriesOfBooks.setId(id);
        CategoriesOfBooks updatedCategoriesOfBooks = categoriesOfBooksService.saveCategoriesOfBooks(categoriesOfBooks);
        return ResponseEntity.ok(updatedCategoriesOfBooks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoriesOfBooks(@PathVariable Long id) {
        if (categoriesOfBooksService.getCategoriesOfBooksById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoriesOfBooksService.deleteCategoriesOfBooks(id);
        return ResponseEntity.noContent().build();
    }
}
