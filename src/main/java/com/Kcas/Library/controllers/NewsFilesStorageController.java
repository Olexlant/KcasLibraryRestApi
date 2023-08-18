package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.NewsFilesStorage;
import com.Kcas.Library.services.NewsFilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news-files-storage")
public class NewsFilesStorageController {
    private final NewsFilesStorageService newsFilesStorageService;

    @Autowired
    public NewsFilesStorageController(NewsFilesStorageService newsFilesStorageService) {
        this.newsFilesStorageService = newsFilesStorageService;
    }

    @GetMapping
    public List<NewsFilesStorage> getAllNewsFilesStorage() {
        return newsFilesStorageService.getAllNewsFilesStorage();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsFilesStorage> getNewsFilesStorageById(@PathVariable Long id) {
        Optional<NewsFilesStorage> newsFilesStorage = newsFilesStorageService.getNewsFilesStorageById(id);
        return newsFilesStorage.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NewsFilesStorage> createNewsFilesStorage(@RequestBody NewsFilesStorage newsFilesStorage) {
        NewsFilesStorage savedNewsFilesStorage = newsFilesStorageService.saveNewsFilesStorage(newsFilesStorage);
        return new ResponseEntity<>(savedNewsFilesStorage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsFilesStorage> updateNewsFilesStorage(@PathVariable Long id, @RequestBody NewsFilesStorage newsFilesStorage) {
        if (newsFilesStorageService.getNewsFilesStorageById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        newsFilesStorage.setId(id);
        NewsFilesStorage updatedNewsFilesStorage = newsFilesStorageService.saveNewsFilesStorage(newsFilesStorage);
        return ResponseEntity.ok(updatedNewsFilesStorage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNewsFilesStorage(@PathVariable Long id) {
        if (newsFilesStorageService.getNewsFilesStorageById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        newsFilesStorageService.deleteNewsFilesStorage(id);
        return ResponseEntity.noContent().build();
    }
}
