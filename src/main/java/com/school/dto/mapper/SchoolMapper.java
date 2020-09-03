package com.school.dto.mapper;

import com.school.dto.SchoolDto;
import com.school.entity.School;

public class SchoolMapper {

    public static SchoolDto schoolToSchoolDto(School school) {
        SchoolDto schoolDto = new SchoolDto(school.getId(), school.getCreateDateTime());

        schoolDto.setName(school.getName());
        schoolDto.setAddress(school.getAddress());
        schoolDto.setCity(school.getCity());
        schoolDto.setSchoolType(school.getSchoolType());
        schoolDto.setSchoolAdmin(UserMapper.userToUserDto(school.getSchoolAdmin()));

        return schoolDto;
    }

}
