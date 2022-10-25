package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "READER")
public class Reader {

    public Reader(String firstName, String lastName, Date createdDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "READER_ID", unique = true)
    private int id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "rent",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rent> rentList;
}
