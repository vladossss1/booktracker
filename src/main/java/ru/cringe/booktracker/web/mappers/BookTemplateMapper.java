package ru.cringe.booktracker.web.mappers;

import org.mapstruct.Mapper;
import ru.cringe.booktracker.domain.author.Author;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;
import ru.cringe.booktracker.web.dto.booktemplate.BookTemplateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookTemplateMapper extends Mappable<BookTemplate, BookTemplateDto> {
}
