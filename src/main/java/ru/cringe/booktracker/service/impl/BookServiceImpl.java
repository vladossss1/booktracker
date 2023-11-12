package ru.cringe.booktracker.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cringe.booktracker.domain.book.Book;
import ru.cringe.booktracker.domain.book.Status;
import ru.cringe.booktracker.domain.exception.ResourceNotFoundException;
import ru.cringe.booktracker.domain.user.User;
import ru.cringe.booktracker.repository.BookRepository;
import ru.cringe.booktracker.service.BookService;
import ru.cringe.booktracker.service.BookTemplateService;
import ru.cringe.booktracker.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final UserService userService;
    private final BookTemplateService bookTemplateService;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "BookService::getById", key = "#id")
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllByUserId(Long id) {
        return bookRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    @CachePut(value = "BookService::getById", key = "#book.id")
    public Book update(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    @Transactional
    @Cacheable(value = "BookService::getById", key = "#book.id")
    public Book create(Book book, Long userId) {
        User user = userService.getById(userId);
        book.setStatus(Status.PLANNED);
        book.setStartTime(LocalDateTime.now());
        book.setCurrentPage(0);
        if (bookTemplateService.isNew(book.getBookTemplate())) {
            book.setBookTemplate(bookTemplateService.create(book.getBookTemplate()));
        }
        bookRepository.save(book);

        user.getBooks().add(book);
        userService.update(user);

        return book;
    }

    @Override
    @Transactional
    @CacheEvict(value = "BookService::getById", key = "#id")
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
