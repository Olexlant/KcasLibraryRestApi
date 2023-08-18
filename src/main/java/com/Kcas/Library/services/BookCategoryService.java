package com.Kcas.Library.services;

import com.Kcas.Library.entities.BookCategory;
import com.Kcas.Library.repositories.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepository.findAll();
    }

    public Optional<BookCategory> getBookCategoryById(Long id) {
        return bookCategoryRepository.findById(id);
    }

    public BookCategory saveBookCategory(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    public void deleteBookCategory(Long id) {
        bookCategoryRepository.deleteById(id);
    }
}
