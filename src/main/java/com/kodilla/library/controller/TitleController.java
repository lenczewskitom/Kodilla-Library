package com.kodilla.library.controller;

import com.kodilla.library.domain.Title;
import com.kodilla.library.domain.TitleDto;
import com.kodilla.library.mapper.TitleMapper;
import com.kodilla.library.service.TitleDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/library/titles", consumes = MediaType.APPLICATION_JSON_VALUE)
public class TitleController {

    private final TitleDbService titleDbService;
    private final TitleMapper titleMapper;

    @GetMapping()
    public ResponseEntity<List<TitleDto>> getTitles() {
        List<Title> list = titleDbService.getTitles();
        return ResponseEntity.ok(titleMapper.mapToTitleDtoList(list));
    }

    @GetMapping(value = "{titleId}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable Integer titleId) throws TitleNotFoundException {
        return new ResponseEntity<>(titleMapper.mapToTitleDto(titleDbService.getTitle(titleId)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> addTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        titleDbService.saveTitle(title);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{titleId}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Integer id) {
        titleDbService.deleteTitle(id);
        return ResponseEntity.ok().build();
    }
}
