package com.Kcas.Library.entities;

import com.Kcas.Library.entities.Book;
import com.Kcas.Library.entities.User;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class LikedBooks {

    @SequenceGenerator(
            name = "liked_books_sequence",
            sequenceName = "liked_books_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "liked_books_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    private LocalDate addedat;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}