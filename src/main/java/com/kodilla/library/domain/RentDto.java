package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RentDto {
    private int rentId;
    private Date rentDate;
    private Date returnDate;
    private int bookId;
    private int readerId;
}
