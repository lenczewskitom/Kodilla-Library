package com.kodilla.library.mapper;

import com.kodilla.library.controller.TitleNotFoundException;
import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import com.kodilla.library.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookMapper {

    private final TitleDbService titleDbService;

    public Book mapToBook(final BookDto bookDto) throws TitleNotFoundException {
        return new Book(
                bookDto.getStatus(),
                titleDbService.getTitle(bookDto.getTitleId())
        );
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getStatus(),
                book.getTitle().getId()
        );
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
