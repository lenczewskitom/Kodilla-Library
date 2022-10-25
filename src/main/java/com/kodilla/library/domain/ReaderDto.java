package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ReaderDto {
    private int id;
    private String firstName;
    private String lastName;
    private Date createdDate;
}
