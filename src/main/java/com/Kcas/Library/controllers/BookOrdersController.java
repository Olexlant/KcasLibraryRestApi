package com.Kcas.Library.controllers;

import com.Kcas.Library.entities.BookOrders;
import com.Kcas.Library.services.BookOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-orders")
public class BookOrdersController {
    private final BookOrdersService bookOrdersService;

    @Autowired
    public BookOrdersController(BookOrdersService bookOrdersService) {
        this.bookOrdersService = bookOrdersService;
    }

    @GetMapping
    public List<BookOrders> getAllBookOrders() {
        return bookOrdersService.getAllBookOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookOrders> getBookOrderById(@PathVariable Long id) {
        Optional<BookOrders> bookOrder = bookOrdersService.getBookOrderById(id);
        return bookOrder.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookOrders> createBookOrder(@RequestBody BookOrders bookOrder) {
        BookOrders savedBookOrder = bookOrdersService.saveBookOrder(bookOrder);
        return new ResponseEntity<>(savedBookOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookOrders> updateBookOrder(@PathVariable Long id, @RequestBody BookOrders bookOrder) {
        if (bookOrdersService.getBookOrderById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookOrder.setId(id);
        BookOrders updatedBookOrder = bookOrdersService.saveBookOrder(bookOrder);
        return ResponseEntity.ok(updatedBookOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookOrder(@PathVariable Long id) {
        if (bookOrdersService.getBookOrderById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookOrdersService.deleteBookOrder(id);
        return ResponseEntity.noContent().build();
    }
}
