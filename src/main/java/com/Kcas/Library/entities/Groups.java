package com.Kcas.Library.entities;

import com.Kcas.Library.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Groups {

    @SequenceGenerator(
            name = "groups_sequence",
            sequenceName = "groups_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groups_sequence"
    )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "groups",cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<User> users = new ArrayList<>();

}
