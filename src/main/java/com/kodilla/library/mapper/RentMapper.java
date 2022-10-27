package com.kodilla.library.mapper;

import com.kodilla.library.controller.BookNotFoundException;
import com.kodilla.library.controller.ReaderNotFoundException;
import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.RentDto;
import com.kodilla.library.service.BookDbService;
import com.kodilla.library.service.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentMapper {

    private final BookDbService bookDbService;
    private final ReaderDbService readerDbService;
    public Rent mapToRent(final RentDto rentDto) throws BookNotFoundException, ReaderNotFoundException {
        return new Rent(
                rentDto.getRentDate(),
                rentDto.getReturnDate(),
                bookDbService.getBook(rentDto.getBookId()),
                readerDbService.getReader(rentDto.getReaderId())
        );
    }

    public RentDto mapToRentDto(final Rent rent) {
        return new RentDto(
                rent.getRentId(),
                rent.getRentDate(),
                rent.getReturnDate(),
                rent.getBook().getId(),
                rent.getReader().getId()
        );
    }

    public List<RentDto> mapToListRentDto(final List<Rent> rentList) {
        return rentList.stream()
                .map(this::mapToRentDto)
                .collect(Collectors.toList());
    }
}
