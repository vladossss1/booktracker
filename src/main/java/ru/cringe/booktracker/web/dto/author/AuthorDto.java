package ru.cringe.booktracker.web.dto.author;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.cringe.booktracker.web.dto.validation.OnUpdate;

@Data
public class AuthorDto {

    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Author must be not null.", groups = OnUpdate.class)
    private String author;
}
