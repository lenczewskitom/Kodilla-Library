package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TitleDto {
    private int id;
    private String title;
    private String author;
    private int year;
}
