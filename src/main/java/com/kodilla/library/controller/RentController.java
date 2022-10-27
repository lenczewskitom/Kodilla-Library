package com.kodilla.library.controller;

import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.RentDto;
import com.kodilla.library.mapper.RentMapper;
import com.kodilla.library.service.RentDbService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/library/rents", consumes = MediaType.APPLICATION_JSON_VALUE)
public class RentController {

    private final RentMapper rentMapper;

    private final RentDbService rentDbService;

    @GetMapping
    public ResponseEntity<List<RentDto>> getRents() {
        List<Rent> rents = rentDbService.getRents();
        return ResponseEntity.ok(rentMapper.mapToListRentDto(rents));
    }

    @PostMapping()
    public ResponseEntity<Object> rentBook(@RequestBody RentDto rentDto) throws BookNotAvailableException, BookNotFoundException, ReaderNotFoundException {
        Rent rent = rentMapper.mapToRent(rentDto);
        rentDbService.rentBook(rent);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RentDto> returnBook(@RequestBody RentDto rentDto) throws RentNotFoundException, ReaderNotFoundException, BookNotFoundException {
        Rent rent = rentMapper.mapToRent(rentDto);
        Rent returned = rentDbService.returnBook(rent);
        return ResponseEntity.ok(rentMapper.mapToRentDto(returned));
    }
}
