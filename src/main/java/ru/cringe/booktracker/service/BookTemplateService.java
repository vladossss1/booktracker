package ru.cringe.booktracker.service;

import ru.cringe.booktracker.domain.booktemplate.BookTemplate;
import ru.cringe.booktracker.domain.booktemplate.Genre;

import java.util.List;

public interface BookTemplateService {

    BookTemplate getById(Long id);

    List<BookTemplate> getAllByTitle(String title);

    List<BookTemplate> getAllByAuthors(List<String> authors);

    List<BookTemplate> getAllByGenres(List<Genre> genres);

    BookTemplate update(BookTemplate bookTemplate);

    void delete(Long id);
}
