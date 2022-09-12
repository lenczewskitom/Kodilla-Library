package com.kodilla.library.service;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.Title;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbService {

    private List<Title> titles = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Rent> rents = new ArrayList<>();

    public List<Title> getTitles() {
        return titles;
    }

    public void saveTitle(final Title title) {
        titles.add(title);
    }

    public void saveReader(final Reader reader) {
        readers.add(reader);
    }

    public void saveBook(final Book book) {
        books.add(book);
    }

    public void rentBook(final Rent rent) {
        rents.add(rent);
    }

    public void returnBook(final Rent rent) {
        rents.remove(rent);
    }
}
