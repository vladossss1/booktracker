package ru.cringe.booktracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;
import ru.cringe.booktracker.domain.booktemplate.Genre;
import ru.cringe.booktracker.repository.BookTemplateRepository;
import ru.cringe.booktracker.service.BookTemplateService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookTemplateServiceImpl implements BookTemplateService {

    private final BookTemplateRepository bookTemplateRepository;

    @Override
    public BookTemplate getById(Long id) {
        return null;
    }

    @Override
    public List<BookTemplate> getAllByTitle(String title) {
        return null;
    }

    @Override
    public List<BookTemplate> getAllByAuthors(List<String> authors) {
        return null;
    }

    @Override
    public List<BookTemplate> getAllByGenres(List<Genre> genres) {
        return null;
    }

    @Override
    public BookTemplate update(BookTemplate bookTemplate) {
        if (bookTemplateRepository.findByTitleAndAuthors(bookTemplate.getTitle(), bookTemplate.getAuthors()) == null){
            bookTemplateRepository.save(bookTemplate);
        }
        return bookTemplate;
    }

    @Override
    public void delete(Long id) {

    }
}
