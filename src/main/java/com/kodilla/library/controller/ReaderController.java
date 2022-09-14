package com.kodilla.library.controller;

import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.domain.*;
import com.kodilla.library.service.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/library", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ReaderController {

    private final ReaderDbService readerDbService;
    private final ReaderMapper readerMapper;

    @PostMapping(value = "/reader")
    public ResponseEntity<Object> addReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        readerDbService.saveReader(reader);
        return ResponseEntity.ok().build();
    }






}
