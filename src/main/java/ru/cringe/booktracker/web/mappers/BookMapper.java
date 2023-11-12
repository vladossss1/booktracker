package ru.cringe.booktracker.web.mappers;

import org.mapstruct.Mapper;
import ru.cringe.booktracker.domain.book.Book;
import ru.cringe.booktracker.web.dto.book.BookDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper extends Mappable<Book, BookDto> {
}
