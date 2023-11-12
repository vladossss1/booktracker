package ru.cringe.booktracker.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cringe.booktracker.domain.booktemplate.BookTemplate;
import ru.cringe.booktracker.service.BookTemplateService;
import ru.cringe.booktracker.web.dto.booktemplate.BookTemplateDto;
import ru.cringe.booktracker.web.dto.validation.OnUpdate;
import ru.cringe.booktracker.web.mappers.BookTemplateMapper;

@RestController
@RequestMapping("/api/v1/bookTemplates")
@RequiredArgsConstructor
@Validated
@Tag(name = "Book Template Controller")
public class BookTemplateController {

    private final BookTemplateService bookTemplateService;

    private final BookTemplateMapper bookTemplateMapper;

    @PutMapping
    @PreAuthorize("isAdmin")
    public BookTemplateDto update(@Validated(OnUpdate.class) @RequestBody BookTemplateDto dto) {
        BookTemplate bookTemplate = bookTemplateMapper.toEntity(dto);
        BookTemplate updatedbookTemplate = bookTemplateService.create(bookTemplate);
        return bookTemplateMapper.toDto(updatedbookTemplate);
    }

    @GetMapping("/{id}")
    public BookTemplateDto getById(@PathVariable Long id) {
        BookTemplate bookTemplate = bookTemplateService.getById(id);
        return bookTemplateMapper.toDto(bookTemplate);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookTemplateService.delete(id);
    }
}
