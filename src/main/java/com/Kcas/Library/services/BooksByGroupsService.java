package com.Kcas.Library.services;

import com.Kcas.Library.entities.BooksByGroups;
import com.Kcas.Library.repositories.BooksByGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksByGroupsService {
    private final BooksByGroupsRepository booksByGroupsRepository;

    @Autowired
    public BooksByGroupsService(BooksByGroupsRepository booksByGroupsRepository) {
        this.booksByGroupsRepository = booksByGroupsRepository;
    }

    public List<BooksByGroups> getAllBooksByGroups() {
        return booksByGroupsRepository.findAll();
    }

    public Optional<BooksByGroups> getBooksByGroupsById(Long id) {
        return booksByGroupsRepository.findById(id);
    }

    public BooksByGroups saveBooksByGroups(BooksByGroups booksByGroups) {
        return booksByGroupsRepository.save(booksByGroups);
    }

    public void deleteBooksByGroups(Long id) {
        booksByGroupsRepository.deleteById(id);
    }
}
