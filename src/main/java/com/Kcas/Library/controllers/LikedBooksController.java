package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.LikedBooks;
import com.Kcas.Library.services.LikedBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/liked-books")
public class LikedBooksController {
    private final LikedBooksService likedBooksService;

    @Autowired
    public LikedBooksController(LikedBooksService likedBooksService) {
        this.likedBooksService = likedBooksService;
    }

    @GetMapping
    public List<LikedBooks> getAllLikedBooks() {
        return likedBooksService.getAllLikedBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LikedBooks> getLikedBookById(@PathVariable Long id) {
        Optional<LikedBooks> likedBook = likedBooksService.getLikedBookById(id);
        return likedBook.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LikedBooks> createLikedBook(@RequestBody LikedBooks likedBook) {
        LikedBooks savedLikedBook = likedBooksService.saveLikedBook(likedBook);
        return new ResponseEntity<>(savedLikedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LikedBooks> updateLikedBook(@PathVariable Long id, @RequestBody LikedBooks likedBook) {
        if (likedBooksService.getLikedBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        likedBook.setId(id);
        LikedBooks updatedLikedBook = likedBooksService.saveLikedBook(likedBook);
        return ResponseEntity.ok(updatedLikedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLikedBook(@PathVariable Long id) {
        if (likedBooksService.getLikedBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        likedBooksService.deleteLikedBook(id);
        return ResponseEntity.noContent().build();
    }
}
