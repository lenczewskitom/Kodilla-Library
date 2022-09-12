package com.kodilla.library.mapper;

import com.kodilla.library.domain.Title;
import com.kodilla.library.domain.TitleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYear()
        );
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYear()
        );
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream()
                .map(this::mapToTitleDto)
                .collect(Collectors.toList());
    }
}
