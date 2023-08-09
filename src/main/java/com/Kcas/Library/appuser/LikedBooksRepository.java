package com.Kcas.Library.appuser;

import com.Kcas.Library.appbook.AppBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LikedBooksRepository extends JpaRepository<LikedBooks,Long> {
    List<LikedBooks> findByUser(AppUser appUser);
    List<LikedBooks> findByUserAndBook(AppUser appUser, AppBook appBook);
    LikedBooks findByBookAndUser(AppBook appBook,AppUser appUser);
    List<LikedBooks> findAllByUser(AppUser user);
    List<LikedBooks> findAllByBook(AppBook book);
    @Transactional
    void deleteAllByUser(AppUser user);
}