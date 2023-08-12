package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.Groups;
import com.Kcas.Library.entities.Book;
import com.Kcas.Library.entities.BooksByGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BooksByGroupsRepository extends JpaRepository<BooksByGroups,Long> {
    ArrayList<BooksByGroups> findAllByGroups(Groups groups);
    ArrayList<BooksByGroups> findAllByGroups_Id(Long groupsId);
    List<BooksByGroups> findByGroupsAndBook(Groups groups, Book book);
    List<BooksByGroups> findByGroups_IdAndBook_Id(Long groupId,Long BookId);
    List<BooksByGroups> findAllByBook(Book book);
    boolean existsByGroups_IdAndBook_Id(Long groupId,Long BookId);

}
