package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitleId(),
                bookDto.getStatus()
        );
    }
}
