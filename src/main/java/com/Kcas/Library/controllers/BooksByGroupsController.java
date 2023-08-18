package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.BooksByGroups;
import com.Kcas.Library.services.BooksByGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books-by-groups")
public class BooksByGroupsController {
    private final BooksByGroupsService booksByGroupsService;

    @Autowired
    public BooksByGroupsController(BooksByGroupsService booksByGroupsService) {
        this.booksByGroupsService = booksByGroupsService;
    }

    @GetMapping
    public List<BooksByGroups> getAllBooksByGroups() {
        return booksByGroupsService.getAllBooksByGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BooksByGroups> getBooksByGroupsById(@PathVariable Long id) {
        Optional<BooksByGroups> booksByGroups = booksByGroupsService.getBooksByGroupsById(id);
        return booksByGroups.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BooksByGroups> createBooksByGroups(@RequestBody BooksByGroups booksByGroups) {
        BooksByGroups savedBooksByGroups = booksByGroupsService.saveBooksByGroups(booksByGroups);
        return new ResponseEntity<>(savedBooksByGroups, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BooksByGroups> updateBooksByGroups(@PathVariable Long id, @RequestBody BooksByGroups booksByGroups) {
        if (booksByGroupsService.getBooksByGroupsById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        booksByGroups.setId(id);
        BooksByGroups updatedBooksByGroups = booksByGroupsService.saveBooksByGroups(booksByGroups);
        return ResponseEntity.ok(updatedBooksByGroups);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooksByGroups(@PathVariable Long id) {
        if (booksByGroupsService.getBooksByGroupsById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        booksByGroupsService.deleteBooksByGroups(id);
        return ResponseEntity.noContent().build();
    }
}
