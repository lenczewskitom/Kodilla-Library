package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "RENT")
public class Rent {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "RENT_ID")
    private int rentId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_ID")
    private Book bookId;

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @Column(name = "RENT_DATE")
    private Date rentDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;
}
