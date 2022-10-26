package com.kodilla.library.service;

import com.kodilla.library.controller.BookNotFoundException;
import com.kodilla.library.domain.Book;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDbService {

    @Autowired
    private final BookRepository bookRepository;

    public List<Book> getBooks() { return bookRepository.findAll(); }

    public Book getBook(final Integer id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public void saveBook(final Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(final Integer id) { bookRepository.deleteById(id);}

    public Book changeStatus(Book book) throws BookNotFoundException {

        Book bookToUpdate = bookRepository.findById(book.getId()).orElseThrow(BookNotFoundException::new);
        bookToUpdate.setStatus(book.getStatus());
        saveBook(bookToUpdate);
        return bookToUpdate;
    }
}
