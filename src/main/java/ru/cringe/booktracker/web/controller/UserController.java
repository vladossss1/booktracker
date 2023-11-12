package ru.cringe.booktracker.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cringe.booktracker.domain.book.Book;
import ru.cringe.booktracker.domain.user.User;
import ru.cringe.booktracker.service.BookService;
import ru.cringe.booktracker.service.UserService;
import ru.cringe.booktracker.web.dto.book.BookDto;
import ru.cringe.booktracker.web.dto.user.UserDto;
import ru.cringe.booktracker.web.dto.validation.OnCreate;
import ru.cringe.booktracker.web.dto.validation.OnUpdate;
import ru.cringe.booktracker.web.mappers.BookMapper;
import ru.cringe.booktracker.web.mappers.UserMapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
@Tag(name = "User Controller")
public class UserController {

    private final UserService userService;
    private final BookService bookService;

    private final UserMapper userMapper;
    private final BookMapper bookMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/books")
    public List<BookDto> getBooksByUserId(@PathVariable Long id) {
        List<Book> books = bookService.getAllByUserId(id);
        return bookMapper.toDto(books);
    }

    @PostMapping("/{id}/books")
    public BookDto createBook(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody BookDto dto) {
        Book book = bookMapper.toEntity(dto);
        Book createdBook = bookService.create(book, id);
        return bookMapper.toDto(createdBook);
    }
}
