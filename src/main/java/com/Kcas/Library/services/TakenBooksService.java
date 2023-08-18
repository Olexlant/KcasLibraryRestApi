package com.Kcas.Library.services;

import com.Kcas.Library.entities.TakenBooks;
import com.Kcas.Library.repositories.TakenBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TakenBooksService {
    private final TakenBooksRepository takenBooksRepository;

    @Autowired
    public TakenBooksService(TakenBooksRepository takenBooksRepository) {
        this.takenBooksRepository = takenBooksRepository;
    }

    public List<TakenBooks> getAllTakenBooks() {
        return takenBooksRepository.findAll();
    }

    public Optional<TakenBooks> getTakenBookById(Long id) {
        return takenBooksRepository.findById(id);
    }

    public TakenBooks saveTakenBook(TakenBooks takenBook) {
        return takenBooksRepository.save(takenBook);
    }

    public void deleteTakenBook(Long id) {
        takenBooksRepository.deleteById(id);
    }
}
