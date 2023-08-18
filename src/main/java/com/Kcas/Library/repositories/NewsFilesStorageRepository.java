package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.NewsFilesStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsFilesStorageRepository extends JpaRepository<NewsFilesStorage, Long> {

}
