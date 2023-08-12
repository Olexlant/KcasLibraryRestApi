package com.Kcas.Library.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class CategoriesOfBooks {

    @SequenceGenerator(
            name = "categories_of_books_sequence",
            sequenceName = "categories_of_books_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categories_of_books_sequence"
    )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    @Fetch(FetchMode.SUBSELECT)
    private List<BookCategory> bookCategories = new ArrayList<>();

}
