package com.Kcas.Library.controllers.book;

import com.Kcas.Library.appbook.AppBookService;
import com.Kcas.Library.appbook.AppBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    @Autowired
    private AppBookService appBookService;

    @GetMapping
    public Page<AppBook> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return appBookService.getAllBooksPagedAndSorted(page, size, sortBy);
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getBooksCount() {
        Integer booksCount = appBookService.getBooksCount();
        return ResponseEntity.ok(booksCount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppBook> getBookById(@PathVariable Long id) {
        Optional<AppBook> book = appBookService.getBookById(id);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AppBook> createBook(@RequestBody AppBook book) {
        AppBook createdBook = appBookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppBook> updateBook(@PathVariable Long id, @RequestBody AppBook book) {
        AppBook updatedBook = appBookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        appBookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
