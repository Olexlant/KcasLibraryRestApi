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
public class BookOrders {

    @SequenceGenerator(
            name = "book_orders_sequence",
            sequenceName = "book_orders_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_orders_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate createdat;
    private boolean deleted;

}
