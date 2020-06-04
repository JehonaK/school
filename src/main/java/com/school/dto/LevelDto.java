package com.school.dto;

import com.school.entity.SchoolClass;

import java.util.List;

public class LevelDto extends DtoEntity {

    private String name;

    private String schoolId;

    private List<SchoolClass> schoolClasses;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }
}
