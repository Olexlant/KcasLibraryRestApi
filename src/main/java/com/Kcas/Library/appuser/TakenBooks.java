package com.Kcas.Library.appuser;

import com.Kcas.Library.appbook.AppBook;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class TakenBooks {

    @SequenceGenerator(
            name = "taken_books_sequence",
            sequenceName = "taken_books_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "taken_books_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private AppBook book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    private LocalDate takenat;
    private Long count;
    private boolean deleted = false;
    private LocalDate returnedAt;
    private boolean notificationSended = false;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
