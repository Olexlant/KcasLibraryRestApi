package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.TakenBooks;
import com.Kcas.Library.services.TakenBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taken-books")
public class TakenBooksController {
    private final TakenBooksService takenBooksService;

    @Autowired
    public TakenBooksController(TakenBooksService takenBooksService) {
        this.takenBooksService = takenBooksService;
    }

    @GetMapping
    public List<TakenBooks> getAllTakenBooks() {
        return takenBooksService.getAllTakenBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TakenBooks> getTakenBookById(@PathVariable Long id) {
        Optional<TakenBooks> takenBook = takenBooksService.getTakenBookById(id);
        return takenBook.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TakenBooks> createTakenBook(@RequestBody TakenBooks takenBook) {
        TakenBooks savedTakenBook = takenBooksService.saveTakenBook(takenBook);
        return new ResponseEntity<>(savedTakenBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TakenBooks> updateTakenBook(@PathVariable Long id, @RequestBody TakenBooks takenBook) {
        if (takenBooksService.getTakenBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        takenBook.setId(id);
        TakenBooks updatedTakenBook = takenBooksService.saveTakenBook(takenBook);
        return ResponseEntity.ok(updatedTakenBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTakenBook(@PathVariable Long id) {
        if (takenBooksService.getTakenBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        takenBooksService.deleteTakenBook(id);
        return ResponseEntity.noContent().build();
    }
}
