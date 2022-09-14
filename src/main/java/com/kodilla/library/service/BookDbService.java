package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookDbService {

    private List<Book> books = new ArrayList<>();

    public void saveBook(final Book book) {
        books.add(book);
    }
}
