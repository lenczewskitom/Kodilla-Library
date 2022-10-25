package com.kodilla.library.mapper;

import com.kodilla.library.controller.TitleNotFoundException;
import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import com.kodilla.library.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMapper {

    private final TitleDbService titleDbService;

    public Book mapToBook(final BookDto bookDto) throws TitleNotFoundException {
        return new Book(
                bookDto.getStatus(),
                titleDbService.getTitle(bookDto.getId())
        );
    }
}
