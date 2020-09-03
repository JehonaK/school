package com.school.dto;

import java.util.List;

public class TeacherToSubjectAssignmentDto {

    private String teacherEmail;
    private List<String> schoolClassIdList;
    private String subjectId;

    public TeacherToSubjectAssignmentDto() {
    }

    public TeacherToSubjectAssignmentDto(String teacherEmail, List<String> schoolClassIdList, String subjectId) {
        this.teacherEmail = teacherEmail;
        this.schoolClassIdList = schoolClassIdList;
        this.subjectId = subjectId;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public List<String> getSchoolClassIdList() {
        return schoolClassIdList;
    }

    public void setSchoolClassIdList(List<String> schoolClassIdList) {
        this.schoolClassIdList = schoolClassIdList;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

}
