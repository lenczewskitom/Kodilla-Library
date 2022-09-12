package com.kodilla.library.controller;

import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.mapper.RentMapper;
import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.TitleMapper;
import com.kodilla.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/library", consumes = MediaType.APPLICATION_JSON_VALUE)
public class LibraryController {

    private final DbService service;
    private final RentMapper rentMapper;
    private final TitleMapper titleMapper;
    private final ReaderMapper readerMapper;
    private final BookMapper bookMapper;


    @GetMapping(value = "/titles")
    public ResponseEntity<List<TitleDto>> getTitles() throws TitleNotFoundException{
        List<Title> list = service.getTitles();
        return ResponseEntity.ok(titleMapper.mapToTitleDtoList(list));
    }

    @PostMapping(value = "/reader")
    public ResponseEntity<Object> addReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        service.saveReader(reader);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/title")
    public ResponseEntity<Object> addTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        service.saveTitle(title);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/book")
    public ResponseEntity<Object> addBook(@RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        service.saveBook(book);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rent")
    public ResponseEntity<Object> rentBook(@RequestBody RentDto rentDto) throws BookNotAvailableException{
        Rent rent = rentMapper.mapToRent(rentDto);
        service.rentBook(rent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/return")
    public ResponseEntity<Object> returnBook(@RequestBody RentDto rentDto) {
        Rent rent = rentMapper.mapToRent(rentDto);
        service.returnBook(rent);
        return ResponseEntity.ok().build();
    }
}
