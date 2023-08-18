package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.TakenBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TakenBooksRepository extends JpaRepository <TakenBooks,Long>, JpaSpecificationExecutor<TakenBooks> {
    List<TakenBooks> findAllByDeletedIsFalseAndNotificationSendedIsFalseAndTakenatIsBefore(LocalDate returnedAt);

}
