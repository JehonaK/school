package com.school.dto.mapper;

import com.school.dto.SubjectDto;
import com.school.entity.Subject;

import java.util.stream.Collectors;

public class SubjectObjectMapper {

    public static SubjectDto toDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setDescription(subject.getDescription());
        subjectDto.setLevelName(subject.getLevel().getName());
        subjectDto.setName(subject.getName());
        subjectDto.setSubjectType(subject.getSubjectType());
        subjectDto.setId(subject.getId());
        subjectDto.setSchoolClasses(subject.getLevel().getSchoolClasses()
                .stream().map(SchoolClassObjectMapper::toDto)
                .collect(Collectors.toList()));

        return subjectDto;
    }
}
