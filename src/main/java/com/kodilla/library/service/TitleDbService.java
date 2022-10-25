package com.kodilla.library.service;

import com.kodilla.library.controller.TitleNotFoundException;
import com.kodilla.library.domain.Title;
import com.kodilla.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TitleDbService {

    @Autowired
    private final TitleRepository titleRepository;

    public List<Title> getTitles() {
        return titleRepository.findAll();
    }

    public Title getTitle(final Integer id) throws TitleNotFoundException{
        return titleRepository.findById(id).orElseThrow(TitleNotFoundException::new); }

    public void saveTitle(final Title title) {
        titleRepository.save(title);
    }

    public void deleteTitle(final Integer id) {titleRepository.deleteById(id);}
}
