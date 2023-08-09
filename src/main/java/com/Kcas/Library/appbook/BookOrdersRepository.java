package com.Kcas.Library.appbook;

import com.Kcas.Library.appuser.AppUser;
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
    List<BookOrders> findByBookAndUserAndDeletedIsFalse(AppBook book, AppUser user);
    List<BookOrders> findAllByBook(AppBook book);
    List<BookOrders> findAllByUser(AppUser user);
    int countAllByDeletedIsFalse();
    HashSet<BookOredersId> findBookOrdersById(Long id);

    @Transactional
    void deleteAllByUser(AppUser appUser);
    @Transactional
    void deleteAllByUserAndBook(AppUser appUser, AppBook book);
    List<BookOrders> findAllById(Long bookorderid);
}