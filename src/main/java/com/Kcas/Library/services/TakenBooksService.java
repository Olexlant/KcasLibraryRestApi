package com.Kcas.Library.services;

import com.Kcas.Library.entities.TakenBooks;
import com.Kcas.Library.repositories.TakenBooksRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TakenBooksService {
    private final TakenBooksRepository takenBooksRepository;

    public TakenBooksService(TakenBooksRepository takenBooksRepository) {
        this.takenBooksRepository = takenBooksRepository;
    }
}
