package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.LikedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikedBooksRepository extends JpaRepository<LikedBooks,Long> {

}
