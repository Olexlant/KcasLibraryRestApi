package com.Kcas.Library.appbook;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AppBookRepository extends JpaRepository<AppBook, Long>, JpaSpecificationExecutor<AppBook> {

    interface BookNoFileAndPhoto {
        Long getId();
        Long getQrid();
        Long getYear();
        Long getCount();
        String getTitle();
        String getDescription();
        String getAuthor();
        String getBookfileurl();
        boolean isElectronic();
    }
    Page<AppBook> findAppBooksByOrderByTitle(Pageable pageable);
    AppBook findAllByIdOrderByTitle(Long id);
    BookNoFileAndPhoto findAppBookById(Long id);
    Page<BookNoFileAndPhoto> findAllByElectronicIsTrueOrderByTitle(Pageable pageable);
    Page<BookNoFileAndPhoto> findAllByElectronicIsFalseOrderByTitle(Pageable pageable);
    Page<BookNoFileAndPhoto> findAllByOrderByTitle(Pageable pageable);
    int countAllBy();
}