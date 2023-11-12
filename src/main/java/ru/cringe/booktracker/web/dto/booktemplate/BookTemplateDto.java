package ru.cringe.booktracker.web.dto.booktemplate;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.cringe.booktracker.domain.booktemplate.Genre;
import ru.cringe.booktracker.web.dto.author.AuthorDto;
import ru.cringe.booktracker.web.dto.validation.OnCreate;
import ru.cringe.booktracker.web.dto.validation.OnUpdate;

import java.util.List;

@Data
public class BookTemplateDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Title must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @NotNull(message = "Authors must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private List<AuthorDto> authors;

    @NotNull(message = "Genres must be not null.", groups = {OnCreate.class, OnUpdate.class})
    private List<Genre> genres;
}
