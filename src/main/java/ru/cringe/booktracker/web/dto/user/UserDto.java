package ru.cringe.booktracker.web.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.cringe.booktracker.web.dto.validation.OnCreate;
import ru.cringe.booktracker.web.dto.validation.OnUpdate;

@Data
@Schema(description = "User")
public class UserDto {

    @Schema(description = "User ID", example = "1")
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @Schema(description = "Username", example = "vladosssssssssssssssssssssssssssssssssssssssssss")
    @NotNull(message = "Username must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length must be smaller than 255 symbols.", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Schema(description = "Password", example = "12345")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class})
    private String password;
}
