package com.school.dto;

import com.school.entity.User;
import com.school.type.ClassStatus;

import java.sql.Timestamp;
import java.util.List;

public class SchoolClassDto extends DtoEntity{

    private String name;
    private ClassStatus classStatus;
    private String levelId;
    private String levelName;
    private List<UserDto> students;

    public SchoolClassDto(String id, Timestamp createDateTime) {
        super(id, createDateTime);
    }

    public SchoolClassDto(String id, Timestamp createDateTime, String name, ClassStatus classStatus, String levelId, String levelName, List<UserDto> students) {
        super(id, createDateTime);
        this.name = name;
        this.classStatus = classStatus;
        this.levelId = levelId;
        this.levelName = levelName;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassStatus getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(ClassStatus classStatus) {
        this.classStatus = classStatus;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public List<UserDto> getStudents() {
        return students;
    }

    public void setStudents(List<UserDto> students) {
        this.students = students;
    }

}
