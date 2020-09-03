package com.school.dto.mapper;

import com.school.dto.LevelDto;
import com.school.dto.SchoolClassDto;
import com.school.dto.SubjectDto;
import com.school.entity.Level;

import java.util.List;
import java.util.stream.Collectors;

public class LevelMapper {

    public static LevelDto levelToLevelDto(Level level) {
        LevelDto levelDto = new LevelDto(level.getId(), level.getCreateDateTime());

        levelDto.setName(level.getName());
        levelDto.setSchool(SchoolMapper.schoolToSchoolDto(level.getSchool()));
        List<SchoolClassDto> schoolClassDtos = level.getSchoolClasses().stream().map(SchoolClassMapper::toDto).collect(Collectors.toList());
        levelDto.setSchoolClasses(schoolClassDtos);
        List<SubjectDto> subjectDtos = level.getSubjects().stream().map(SubjectObjectMapper::subjectToSubjectDto).collect(Collectors.toList());
        levelDto.setSubjects(subjectDtos);

        return levelDto;
    }

}
