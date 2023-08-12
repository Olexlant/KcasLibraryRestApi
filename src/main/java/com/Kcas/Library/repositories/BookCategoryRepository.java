package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory,Long> {
    ArrayList<BookCategory> findAllByCategoryId(Long id);
    List<BookCategory> findAllByBookId(Long id);

    BookCategory findByCategory_IdAndBook_Id (Long categoryId, Long bookId);
}
