package com.kodilla.library.controller;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.service.BookDbService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/library/books", consumes = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookMapper bookMapper;
    private final BookDbService bookDbService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = bookDbService.getBooks();
        return ResponseEntity.ok(bookMapper.mapToBookDtoList(books));
    }

    @GetMapping(value = "{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable Integer bookId) throws BookNotFoundException {
        return new ResponseEntity<>(bookMapper.mapToBookDto(bookDbService.getBook(bookId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> addBook(@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
        bookDbService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{bookId}/{status}")
    public ResponseEntity<BookDto> changeStatus(@PathVariable Integer bookId, @PathVariable String status) throws TitleNotFoundException, BookNotFoundException {
        Book updatedBook = bookDbService.changeStatus(bookId, status);
        return ResponseEntity.ok(bookMapper.mapToBookDto(updatedBook));
    }
}
