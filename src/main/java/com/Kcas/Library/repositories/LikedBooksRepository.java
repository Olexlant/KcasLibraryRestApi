package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.Book;
import com.Kcas.Library.entities.LikedBooks;
import com.Kcas.Library.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikedBooksRepository extends JpaRepository<LikedBooks,Long> {
    List<LikedBooks> findByUser(User user);
    List<LikedBooks> findByUserAndBook(User user, Book book);
    LikedBooks findByBookAndUser(Book book, User user);
    List<LikedBooks> findAllByUser(User user);
    List<LikedBooks> findAllByBook(Book book);
    @Transactional
    void deleteAllByUser(User user);
}
