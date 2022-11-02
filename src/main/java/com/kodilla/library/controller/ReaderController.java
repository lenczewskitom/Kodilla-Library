package com.kodilla.library.controller;

import com.kodilla.library.mapper.ReaderMapper;
import com.kodilla.library.domain.*;
import com.kodilla.library.service.ReaderDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/library/readers")
public class ReaderController {

    private final ReaderDbService readerDbService;
    private final ReaderMapper readerMapper;

    @GetMapping
    public ResponseEntity<List<ReaderDto>> getReaders() {
        List<Reader> readers = readerDbService.getAllReaders();
        return ResponseEntity.ok(readerMapper.mapToReaderDtoList(readers));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        readerDbService.saveReader(reader);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Integer readerId) {
        readerDbService.deleteReader(readerId);
        return ResponseEntity.ok().build();
    }

}
