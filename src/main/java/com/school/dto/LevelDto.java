package com.school.dto;

import com.school.annotations.ApiEntity;

import java.sql.Timestamp;
import java.util.List;

@ApiEntity
public class LevelDto extends DtoEntity {

    private String name;
    private SchoolDto school;
    private List<SchoolClassDto> schoolClasses;
    private List<SubjectDto> subjects;

    public LevelDto() {
    }

    public LevelDto(String id, Timestamp createDateTime) {
        super(id, createDateTime);
    }

    public LevelDto(String id, Timestamp createDateTime, String name, SchoolDto school, List<SchoolClassDto> schoolClasses, List<SubjectDto> subjects) {
        super(id, createDateTime);
        this.name = name;
        this.school = school;
        this.schoolClasses = schoolClasses;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchoolDto getSchool() {
        return school;
    }

    public void setSchool(SchoolDto school) {
        this.school = school;
    }

    public List<SchoolClassDto> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassDto> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public List<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDto> subjects) {
        this.subjects = subjects;
    }

}
