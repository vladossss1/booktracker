package ru.cringe.booktracker.service.impl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import ru.cringe.booktracker.domain.author.Author;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;
import ru.cringe.booktracker.domain.booktemplate.Genre;
import ru.cringe.booktracker.domain.exception.ResourceNotFoundException;
import ru.cringe.booktracker.repository.BookTemplateRepository;
import ru.cringe.booktracker.service.BookTemplateService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookTemplateServiceImpl implements BookTemplateService {

  private final BookTemplateRepository bookTemplateRepository;

  @Override
  @CachePut(value = "BookTemplateService::getById", key = "#id")
  public BookTemplate getById(Long id) {
    return bookTemplateRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Book template not found"));
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
  @Cacheable(value = "BookTemplateService::getById",
      condition = "#bookTemplate.id!=null",
      key = "#bookTemplate.id")
  public BookTemplate create(BookTemplate bookTemplate) {
    bookTemplateRepository.save(bookTemplate);
    return bookTemplate;
  }

  @Override
  @Caching(evict = {
      @CacheEvict(value = "BookTemplateService::getById", key = "#id"),
      @CacheEvict(value = "BookTemplateService::isNew", key = "#id")
  })
  public void delete(Long id) {

  }

  @Override
  @Cacheable(value = "BookTemplateService::isNew",
      condition = "#bookTemplate.id!=null",
      key = "#bookTemplate.id")
  public boolean isNew(BookTemplate bookTemplate) {
    return bookTemplateRepository.findAllByTitleAndAuthors(bookTemplate.getTitle(),
        bookTemplate.getAuthors().stream().map(Author::getId).collect(Collectors.toList())) == null;
  }
}
