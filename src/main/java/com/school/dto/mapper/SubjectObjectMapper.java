package com.school.dto.mapper;

import com.school.dto.SubjectDto;
import com.school.entity.Subject;

import java.util.stream.Collectors;

public class SubjectObjectMapper {

    public static SubjectDto subjectToSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto(subject.getId(), subject.getCreateDateTime());

        subjectDto.setDescription(subject.getDescription());
        subjectDto.setLevelName(subject.getLevel().getName());
        subjectDto.setName(subject.getName());
        subjectDto.setSubjectType(subject.getSubjectType());
        subjectDto.setId(subject.getId());
        subjectDto.setSchoolClasses(subject.getLevel().getSchoolClasses()
                .stream().map(SchoolClassMapper::toDto)
                .collect(Collectors.toList()));

        return subjectDto;
    }
}
