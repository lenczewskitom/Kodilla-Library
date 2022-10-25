package com.kodilla.library.controller;

import com.kodilla.library.domain.Rent;
import com.kodilla.library.domain.RentDto;
import com.kodilla.library.mapper.RentMapper;
import com.kodilla.library.service.RentDbService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/library/rents", consumes = MediaType.APPLICATION_JSON_VALUE)
public class RentController {

    private final RentMapper rentMapper;

    private final RentDbService rentDbService;

    @PostMapping()
    public ResponseEntity<Object> rentBook(@RequestBody RentDto rentDto) throws BookNotAvailableException{
        Rent rent = rentMapper.mapToRent(rentDto);
        rentDbService.rentBook(rent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Object> returnBook(@RequestBody RentDto rentDto) {
        Rent rent = rentMapper.mapToRent(rentDto);
        rentDbService.returnBook(rent);
        return ResponseEntity.ok().build();
    }
}
