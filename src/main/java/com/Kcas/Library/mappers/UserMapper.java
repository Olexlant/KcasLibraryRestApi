package com.Kcas.Library.mappers;

import com.Kcas.Library.dtos.SignUpDto;
import com.Kcas.Library.dtos.UserDto;
import com.Kcas.Library.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto userDto);
}
