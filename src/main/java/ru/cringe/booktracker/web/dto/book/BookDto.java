package ru.cringe.booktracker.web.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.cringe.booktracker.domain.book.Status;
import ru.cringe.booktracker.web.dto.booktemplate.BookTemplateDto;
import ru.cringe.booktracker.web.dto.validation.OnCreate;
import ru.cringe.booktracker.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;

@Data
@Schema(description = "Book with personal info from user")
public class BookDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Book template must be not null.", groups = OnCreate.class)
    private BookTemplateDto bookTemplate;

    private Status status;

    private Short rating;

    private Integer totalPages;

    private Integer currentPage;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime finishTime;

    @Length(max = 1024, message = "Comment length must be smaller than 1024 symbols.")
    private String comment;
}
