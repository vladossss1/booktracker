package ru.cringe.booktracker.web.mappers;

import org.mapstruct.Mapper;
import ru.cringe.booktracker.domain.user.User;
import ru.cringe.booktracker.web.dto.user.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto>{
}
