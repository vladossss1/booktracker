package ru.cringe.booktracker.web.mappers;

import org.mapstruct.Mapper;
import ru.cringe.booktracker.domain.author.Author;
import ru.cringe.booktracker.web.dto.author.AuthorDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    List<AuthorDto> toDto(List<Author> authors);

    Author toEntity(AuthorDto dto);
}
