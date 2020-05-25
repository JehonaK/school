package com.school.dto;

public class StudentToClassAssignmentDto {

    private String email;
    private String schoolClassId;

    public StudentToClassAssignmentDto(String email, String schoolClassId) {
        this.email = email;
        this.schoolClassId = schoolClassId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(String schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

}
