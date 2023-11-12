package ru.cringe.booktracker.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cringe.booktracker.domain.book.Book;
import ru.cringe.booktracker.service.BookService;
import ru.cringe.booktracker.web.dto.book.BookDto;
import ru.cringe.booktracker.web.dto.validation.OnUpdate;
import ru.cringe.booktracker.web.mappers.BookMapper;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@Validated
@Tag(name = "Book Controller")
public class BookController {

    private final BookService bookService;

    private final BookMapper bookMapper;

    @PutMapping
    public BookDto update(@Validated(OnUpdate.class) @RequestBody BookDto bookDto){
        Book book = bookMapper.toEntity(bookDto);
        Book updatedBook = bookService.update(book);
        return bookMapper.toDto(updatedBook);
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable Long id){
        Book book = bookService.getById(id);
        return bookMapper.toDto(book);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        bookService.delete(id);
    }
}
