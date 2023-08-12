package com.Kcas.Library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;
    private Long qrid;
    private String title;
    private String author;
    private Long year;

    @JsonIgnore
    @Basic(fetch=FetchType.LAZY)
    private byte[] bookimg;

    @JsonIgnore
    @Basic(fetch=FetchType.LAZY)
    private byte[] qrimg;

    @JsonIgnore
    @Basic(fetch=FetchType.LAZY)
    private byte[] bookfile;
    private String bookfileurl;
    @Column(columnDefinition="text", length=10485760)
    private String description;
    private Long count;
    private boolean electronic = false;

    public Book(Long qrid, String title, String author, Long year, byte[] bookimg, byte[] qrimg, byte[] bookfile, boolean electronic){
        this.qrid = qrid;
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookimg = bookimg;
        this.qrimg = qrimg;
        this.bookfile = bookfile;
        this.electronic = electronic;
    }
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private Set<LikedBooks> likedBooks;
    @JsonIgnore
    @OneToMany(mappedBy = "book")
    @Fetch(FetchMode.SUBSELECT)
    private List<TakenBooks> takenBooks= new ArrayList<>();
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book", orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private Set<BooksByGroups> booksByGroups;


}
