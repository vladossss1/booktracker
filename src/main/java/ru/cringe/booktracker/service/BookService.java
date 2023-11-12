package ru.cringe.booktracker.service;

import ru.cringe.booktracker.domain.book.Book;

import java.util.List;

public interface BookService {

    Book getById(Long id);

    List<Book> getAllByUserId(Long id);

    Book update(Book book);

    Book create(Book book, Long userId);

    void delete(Long id);
}
