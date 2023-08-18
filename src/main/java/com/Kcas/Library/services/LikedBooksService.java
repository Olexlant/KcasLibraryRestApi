package com.Kcas.Library.services;

import com.Kcas.Library.entities.LikedBooks;
import com.Kcas.Library.repositories.LikedBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikedBooksService {
    private final LikedBooksRepository likedBooksRepository;

    @Autowired
    public LikedBooksService(LikedBooksRepository likedBooksRepository) {
        this.likedBooksRepository = likedBooksRepository;
    }

    public List<LikedBooks> getAllLikedBooks() {
        return likedBooksRepository.findAll();
    }

    public Optional<LikedBooks> getLikedBookById(Long id) {
        return likedBooksRepository.findById(id);
    }

    public LikedBooks saveLikedBook(LikedBooks likedBook) {
        return likedBooksRepository.save(likedBook);
    }

    public void deleteLikedBook(Long id) {
        likedBooksRepository.deleteById(id);
    }
}
