package com.Kcas.Library.services;

import com.Kcas.Library.entities.CategoriesOfBooks;
import com.Kcas.Library.repositories.CategoriesOfBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesOfBooksService {
    private final CategoriesOfBooksRepository categoriesOfBooksRepository;

    @Autowired
    public CategoriesOfBooksService(CategoriesOfBooksRepository categoriesOfBooksRepository) {
        this.categoriesOfBooksRepository = categoriesOfBooksRepository;
    }

    public List<CategoriesOfBooks> getAllCategoriesOfBooks() {
        return categoriesOfBooksRepository.findAll();
    }

    public Optional<CategoriesOfBooks> getCategoriesOfBooksById(Long id) {
        return categoriesOfBooksRepository.findById(id);
    }

    public CategoriesOfBooks saveCategoriesOfBooks(CategoriesOfBooks categoriesOfBooks) {
        return categoriesOfBooksRepository.save(categoriesOfBooks);
    }

    public void deleteCategoriesOfBooks(Long id) {
        categoriesOfBooksRepository.deleteById(id);
    }
}
