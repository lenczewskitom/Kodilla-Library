package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BOOK")
public class Book {

    public Book(String status, Title title) {
        this.status = status;
        this.title = title;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "BOOK_ID", unique = true)
    private int id;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;
}
