package com.Kcas.Library.services;

import com.Kcas.Library.entities.NewsFilesStorage;
import com.Kcas.Library.repositories.NewsFilesStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsFilesStorageService {
    private final NewsFilesStorageRepository newsFilesStorageRepository;

    @Autowired
    public NewsFilesStorageService(NewsFilesStorageRepository newsFilesStorageRepository) {
        this.newsFilesStorageRepository = newsFilesStorageRepository;
    }

    public List<NewsFilesStorage> getAllNewsFilesStorage() {
        return newsFilesStorageRepository.findAll();
    }

    public Optional<NewsFilesStorage> getNewsFilesStorageById(Long id) {
        return newsFilesStorageRepository.findById(id);
    }

    public NewsFilesStorage saveNewsFilesStorage(NewsFilesStorage newsFilesStorage) {
        return newsFilesStorageRepository.save(newsFilesStorage);
    }

    public void deleteNewsFilesStorage(Long id) {
        newsFilesStorageRepository.deleteById(id);
    }
}
