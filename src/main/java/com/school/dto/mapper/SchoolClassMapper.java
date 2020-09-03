package com.school.dto.mapper;

import com.school.dto.SchoolClassDto;
import com.school.dto.UserDto;
import com.school.entity.SchoolClass;

import java.util.List;
import java.util.stream.Collectors;

public class SchoolClassMapper {

    public static SchoolClassDto toDto(SchoolClass schoolClass) {
        SchoolClassDto schoolClassDto = new SchoolClassDto(schoolClass.getId(), schoolClass.getCreateDateTime());

        schoolClassDto.setClassStatus(schoolClass.getClassStatus());
        schoolClassDto.setName(schoolClass.getName());
        schoolClassDto.setLevelName(schoolClass.getLevel().getName());
        schoolClassDto.setLevelId(schoolClass.getLevel().getName());
        schoolClassDto.setId(schoolClass.getId());
        List<UserDto> studentsDto = schoolClass.getStudents().stream().map(UserMapper::userToUserDto).collect(Collectors.toList());
        schoolClassDto.setStudents(studentsDto);

        return schoolClassDto;
    }
}
