package com.school.dto.mapper;

import com.school.dto.SchoolClassDto;
import com.school.entity.SchoolClass;

public class SchoolClassObjectMapper {

    public static SchoolClassDto toDto(SchoolClass schoolClass) {
        SchoolClassDto schoolClassDto = new SchoolClassDto();

        schoolClassDto.setClassStatus(schoolClass.getClassStatus());
        schoolClassDto.setName(schoolClass.getName());
        schoolClassDto.setLevelName(schoolClass.getLevel().getName());
        schoolClassDto.setLevelId(schoolClass.getLevel().getName());
        schoolClassDto.setId(schoolClass.getId());
        schoolClassDto.setStudents(schoolClass.getStudents());

        return schoolClassDto;
    }
}
