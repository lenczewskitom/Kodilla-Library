package com.kodilla.library.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RentDto {
    private int bookId;
    private int readerId;
    private Date rentDate;
    private Date returnDate;
}
