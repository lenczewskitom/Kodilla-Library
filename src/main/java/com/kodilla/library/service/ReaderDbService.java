package com.kodilla.library.service;

import com.kodilla.library.domain.Reader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderDbService {
    private List<Reader> readers = new ArrayList<>();

    public void saveReader(final Reader reader) {
        readers.add(reader);
    }
}
