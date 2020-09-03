package com.school.dto;

import com.school.entity.SchoolClass;
import com.school.type.SubjectType;

import java.sql.Timestamp;
import java.util.List;

public class SubjectDto extends DtoEntity{

    private String name;

    private String levelId;

    private String levelName;

    private String description;

    private SubjectType subjectType;

    private List<SchoolClassDto> schoolClasses;

    public SubjectDto(String id, Timestamp createDateTime) {
        super(id, createDateTime);
    }

    public SubjectDto(String id, Timestamp createDateTime, String name, String levelId, String levelName, String description, SubjectType subjectType, List<SchoolClassDto> schoolClasses) {
        super(id, createDateTime);
        this.name = name;
        this.levelId = levelId;
        this.levelName = levelName;
        this.description = description;
        this.subjectType = subjectType;
        this.schoolClasses = schoolClasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<SchoolClassDto> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassDto> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
}
