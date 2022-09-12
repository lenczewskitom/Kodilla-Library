package com.kodilla.library.mapper;

import com.kodilla.library.domain.Reader;
import com.kodilla.library.domain.ReaderDto;
import org.springframework.stereotype.Service;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getCreatedDate()
        );
    }
}
