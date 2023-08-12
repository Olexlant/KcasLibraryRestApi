package com.Kcas.Library.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class BooksByGroups {

    @SequenceGenerator(
            name = "books_by_group_sequence",
            sequenceName = "books_by_group_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "books_by_group_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Groups groups;
}
