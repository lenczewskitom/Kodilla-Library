package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TITLE")
public class Title {

    public Title(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "TITLE_ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "YEAR")
    private int year;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Book> books;
}
