package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.Book;
import com.Kcas.Library.entities.TakenBooks;
import com.Kcas.Library.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TakenBooksRepository extends JpaRepository <TakenBooks,Long>, JpaSpecificationExecutor<TakenBooks> {
    List<TakenBooks> findByUserAndDeletedIsFalse(User user);
    List<TakenBooks> findByUserAndDeletedIsTrue(User user);
    List<TakenBooks> findByUserAndBookAndDeletedIsFalse(User user, Book book);
    boolean existsByUserIdAndBookIdAndDeletedIsFalse(Long userId, Long bookId);
    Optional<TakenBooks> findByBookIdAndDeletedIsFalse(Long id);
    List<TakenBooks> findAllByUser(User user);
    List<TakenBooks> findAllByUserAndDeletedIsFalse(User user);
    List<TakenBooks> findAllByBook(Book book);
    List<TakenBooks> findAllByBookAndDeletedIsTrue(Book book);
    Page<TakenBooks> findAllByDeletedIsFalse(Pageable pageable);
    Page<TakenBooks> findAllByDeletedIsTrue(Pageable pageable);
    List<TakenBooks> findAllByDeletedIsFalseAndNotificationSendedIsFalseAndTakenatIsBefore(LocalDate returnedAt);
    Page<TakenBooks> findAllByDeletedIsFalseAndTakenatIsBefore(Pageable pageable, LocalDate returnedAt);
    List<TakenBooks> findAllByDeletedIsTrue();
    @Transactional
    void deleteAllByUserAndDeletedIsTrue(User user);

    @Transactional
    void deleteAllByDeletedIsTrue();

    boolean existsByUserAndDeletedIsTrue(User user);

    int countAllBy();
    int countAllByDeletedIsFalse();
}
