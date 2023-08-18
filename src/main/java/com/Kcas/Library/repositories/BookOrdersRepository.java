package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.BookOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOrdersRepository extends JpaRepository<BookOrders, Long> {

}
