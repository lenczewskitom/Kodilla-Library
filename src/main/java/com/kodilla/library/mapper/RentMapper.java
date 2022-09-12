package com.kodilla.library.mapper;

import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.RentDto;
import org.springframework.stereotype.Service;

@Service
public class RentMapper {
    public Rent mapToRent(final RentDto rentDto) {
        return new Rent(
                rentDto.getBookId(),
                rentDto.getReaderId(),
                rentDto.getRentDate(),
                rentDto.getReturnDate()
        );
    }
}
