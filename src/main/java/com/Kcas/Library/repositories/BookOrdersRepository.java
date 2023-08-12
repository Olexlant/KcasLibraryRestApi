package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.Book;
import com.Kcas.Library.entities.BookOrders;
import com.Kcas.Library.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Repository
public interface BookOrdersRepository extends JpaRepository<BookOrders, Long> {




    interface BookOredersId{
        Long getId();
    }
    Page<BookOrders> findAllByDeletedIsFalse(Pageable pageable);
    List<BookOrders> findByBookAndUserAndDeletedIsFalse(Book book, User user);
    List<BookOrders> findAllByBook(Book book);
    List<BookOrders> findAllByUser(User user);
    int countAllByDeletedIsFalse();
    HashSet<BookOredersId> findBookOrdersById(Long id);

    @Transactional
    void deleteAllByUser(User user);
    @Transactional
    void deleteAllByUserAndBook(User user, Book book);
    List<BookOrders> findAllById(Long bookorderid);
}
