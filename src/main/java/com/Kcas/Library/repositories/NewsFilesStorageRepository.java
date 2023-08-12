package com.Kcas.Library.repositories;

import com.Kcas.Library.entities.News;
import com.Kcas.Library.entities.NewsFilesStorage;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsFilesStorageRepository extends JpaRepository<NewsFilesStorage, Long> {
    interface NewsFileInfo{
        Long getId();
        String getFileName();
        String getFileContentType();
        News getNews();
    }

    NewsFilesStorage findAllById(Long newsfileid);
    List<NewsFileInfo> findAllByNews_Id(Long newsId);
    @Transactional
    void deleteAllByNews_Id(Long newsId);
}
