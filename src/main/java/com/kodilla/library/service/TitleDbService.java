package com.kodilla.library.service;

import com.kodilla.library.domain.Title;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitleDbService {
    private List<Title> titles = new ArrayList<>();

    public List<Title> getTitles() {
        return titles;
    }

    public void saveTitle(final Title title) {
        titles.add(title);
    }
}
