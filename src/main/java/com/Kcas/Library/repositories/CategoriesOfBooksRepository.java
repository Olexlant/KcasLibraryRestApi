package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.CategoriesOfBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesOfBooksRepository extends JpaRepository<CategoriesOfBooks, Long> {


}
