package com.kodilla.library.service;

import com.kodilla.library.controller.TitleNotFoundException;
import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TitleDbService {

    @Autowired
    private final TitleRepository titleRepository;

    @Autowired
    private final BookRepository bookRepository;

    public List<Title> getTitles() {
        return titleRepository.findAll();
    }

    public Title getTitle(final Integer id) throws TitleNotFoundException{
        return titleRepository.findById(id).orElseThrow(TitleNotFoundException::new); }

    public void saveTitle(final Title title) {
        titleRepository.save(title);
    }

    public void deleteTitle(final Integer id) {titleRepository.deleteById(id);}

    public Integer getAvailableBooks(final String title) {
        List<Book> books = bookRepository.findAll().stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
        return books.size();
    }
}
