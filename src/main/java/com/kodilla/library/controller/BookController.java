package com.kodilla.library.controller;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.service.BookDbService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/library/books", consumes = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookMapper bookMapper;
    private final BookDbService bookDbService;

    @PostMapping()
    public ResponseEntity<Object> addBook(@RequestBody BookDto bookDto) throws TitleNotFoundException {
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);
        return ResponseEntity.ok().build();
    }
}
