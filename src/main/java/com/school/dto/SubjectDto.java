package com.school.dto;

import com.school.entity.SchoolClass;
import com.school.type.SubjectType;

import java.util.List;

public class SubjectDto extends DtoEntity{

    private String id;

    private String name;

    private String levelId;

    private String levelName;

    private String description;

    private SubjectType subjectType;

    private List<SchoolClassDto> schoolClasses;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SchoolClassDto> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClassDto> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
}
