package com.school.dto.mapper;

import com.school.dto.UserDto;
import com.school.entity.User;

public class UserMapper {

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto(user.getId(), user.getCreateDateTime());

        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());

        return userDto;
    }

}
