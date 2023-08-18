package com.Kcas.Library.services;

import com.Kcas.Library.entities.BookOrders;
import com.Kcas.Library.repositories.BookOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookOrdersService {
    private final BookOrdersRepository bookOrdersRepository;

    @Autowired
    public BookOrdersService(BookOrdersRepository bookOrdersRepository) {
        this.bookOrdersRepository = bookOrdersRepository;
    }

    public List<BookOrders> getAllBookOrders() {
        return bookOrdersRepository.findAll();
    }

    public Optional<BookOrders> getBookOrderById(Long id) {
        return bookOrdersRepository.findById(id);
    }

    public BookOrders saveBookOrder(BookOrders bookOrder) {
        return bookOrdersRepository.save(bookOrder);
    }

    public void deleteBookOrder(Long id) {
        bookOrdersRepository.deleteById(id);
    }
}
