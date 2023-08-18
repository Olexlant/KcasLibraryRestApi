package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.BooksByGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksByGroupsRepository extends JpaRepository<BooksByGroups,Long> {

}
