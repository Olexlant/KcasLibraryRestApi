package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.BookCategory;
import com.Kcas.Library.services.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {
    private final BookCategoryService bookCategoryService;

    @Autowired
    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    public List<BookCategory> getAllBookCategories() {
        return bookCategoryService.getAllBookCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCategory> getBookCategoryById(@PathVariable Long id) {
        Optional<BookCategory> bookCategory = bookCategoryService.getBookCategoryById(id);
        return bookCategory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookCategory> createBookCategory(@RequestBody BookCategory bookCategory) {
        BookCategory savedBookCategory = bookCategoryService.saveBookCategory(bookCategory);
        return new ResponseEntity<>(savedBookCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookCategory> updateBookCategory(@PathVariable Long id, @RequestBody BookCategory bookCategory) {
        if (bookCategoryService.getBookCategoryById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookCategory.setId(id);
        BookCategory updatedBookCategory = bookCategoryService.saveBookCategory(bookCategory);
        return ResponseEntity.ok(updatedBookCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable Long id) {
        if (bookCategoryService.getBookCategoryById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookCategoryService.deleteBookCategory(id);
        return ResponseEntity.noContent().build();
    }
}
