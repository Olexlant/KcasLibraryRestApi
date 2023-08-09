package com.Kcas.Library.appbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppBookService {

    @Autowired
    private AppBookRepository appBookRepository;

    public Page<AppBook> getAllBooksPagedAndSorted(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return appBookRepository.findAll(pageable);
    }

    public Integer getBooksCount() {
        return appBookRepository.countAllBy();
    }

    public Optional<AppBook> getBookById(Long id) {
        return appBookRepository.findById(id);
    }

    public AppBook createBook(AppBook book) {
        return appBookRepository.save(book);
    }

    public AppBook updateBook(Long id, AppBook book) {
        book.setId(id); // Ensure the correct ID is set
        return appBookRepository.save(book);
    }

    public void deleteBook(Long id) {
        appBookRepository.deleteById(id);
    }
}



