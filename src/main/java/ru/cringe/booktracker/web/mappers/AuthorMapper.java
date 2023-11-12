package ru.cringe.booktracker.web.mappers;

import org.mapstruct.Mapper;
import ru.cringe.booktracker.domain.author.Author;
import ru.cringe.booktracker.web.dto.author.AuthorDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends Mappable<Author, AuthorDto> {
}
