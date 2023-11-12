package ru.cringe.booktracker.web.mappers;

import org.mapstruct.Mapper;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;
import ru.cringe.booktracker.web.dto.booktemplate.BookTemplateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookTemplateMapper {

    BookTemplateDto toDto(BookTemplate book);

    List<BookTemplateDto> toDto(List<BookTemplate> bookTemplates);

    BookTemplate toEntity(BookTemplateDto dto);
}
