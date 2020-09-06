package com.school.dto;

import com.school.annotations.ApiEntity;

@ApiEntity
public class StudentToClassAssignmentDto {

    private String studentEmail;
    private String schoolClassId;

    public StudentToClassAssignmentDto() {
    }

    public StudentToClassAssignmentDto(String studentEmail, String schoolClassId) {
        this.studentEmail = studentEmail;
        this.schoolClassId = schoolClassId;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(String schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

}
