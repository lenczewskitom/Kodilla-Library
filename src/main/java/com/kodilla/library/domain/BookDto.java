package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private int id;
    private int titleId;
    private String status;
}
