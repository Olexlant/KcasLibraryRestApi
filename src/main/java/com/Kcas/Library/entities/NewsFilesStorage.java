package com.Kcas.Library.entities;

import com.Kcas.Library.entities.News;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class NewsFilesStorage {
    @SequenceGenerator(
            name = "news_files_sequence",
            sequenceName = "news_files_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "news_files_sequence"
    )
    private Long id;
    private String fileName;
    private String fileContentType;
    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;
    private byte[] file;
}
