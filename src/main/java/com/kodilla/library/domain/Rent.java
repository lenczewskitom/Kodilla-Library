package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Rent {
    private int bookId;
    private int readerId;
    private Date rentDate;
    private Date returnDate;
}
