package com.kodilla.library.service;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReaderDbService {
    @Autowired
    private final ReaderRepository readerRepository;

    public void saveReader(final Reader reader) {
        readerRepository.save(reader);
    }

    public List<Reader> getAllReaders() { return readerRepository.findAll(); }

    public void deleteReader(final Integer id) { readerRepository.deleteById(id); }
}
